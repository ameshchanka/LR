package by.itacademy.repository;

import by.itacademy.dto.LeaseAdDto;
import by.itacademy.dto.LeaseRoomsDto;
import by.itacademy.dto.filters.LeaseFilterDto;
import by.itacademy.entity.LeaseAd;
import by.itacademy.entity.QLeaseAd;
import by.itacademy.entity.QRoom;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class LeaseAdRepositoryImpl implements LeaseAdRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<LeaseAd> findLeaseRoomsByModel(LeaseRoomsDto leaseRoomsDto) {
        List<LeaseAd> result;
        LeaseFilterDto filter = leaseRoomsDto.getFilter();
        Long offsetNumber = (leaseRoomsDto.getPaging().getCurrentPage() - 1) * leaseRoomsDto.getPaging().getItemsPerPage();

        JPAQuery<LeaseAd> query = new JPAQuery<LeaseAd>(entityManager);
        QLeaseAd leaseAd = QLeaseAd.leaseAd;
        QRoom room = leaseAd.room;
        query.select(leaseAd)
                .from(leaseAd);
        if (filter.getPriceMin() != null) {
            query.where(leaseAd.price.gt(filter.getPriceMin()));
        }
        if (filter.getPriceMax() != null) {
            query.where(leaseAd.price.lt(filter.getPriceMax()));
        }
        if (filter.getSquareMin() != null) {
            query.where(room.square.gt(filter.getSquareMin()));
        }
        if (filter.getSquareMax() != null) {
            query.where(room.square.lt(filter.getSquareMax()));
        }
        if (filter.getPm2Min() != null) {
            query.where(room.square.isNotNull()
                    .and(leaseAd.price.divide(room.square).gt(filter.getPm2Min())));
        }
        if (filter.getPm2Max() != null) {
            query.where(room.square.isNotNull()
                    .and(leaseAd.price.divide(room.square).lt(filter.getPm2Max())));
        }

        result = query
                .offset(offsetNumber)
                .limit(leaseRoomsDto.getPaging().getItemsPerPage())
                .fetchResults()
                .getResults();
        return result;
    }

    @Override
    public Long countLeaseRoomsByModel(LeaseRoomsDto leaseRoomsDto) {
        Long result;
        LeaseFilterDto filter = leaseRoomsDto.getFilter();

        JPAQuery<Long> query = new JPAQuery<Long>(entityManager);
        QLeaseAd leaseAd = QLeaseAd.leaseAd;
        QRoom room = leaseAd.room;
        query.select(leaseAd.count())
                .from(leaseAd);
        if (filter.getPriceMin() != null) {
            query.where(leaseAd.price.gt(filter.getPriceMin()));
        }
        if (filter.getPriceMax() != null) {
            query.where(leaseAd.price.lt(filter.getPriceMax()));
        }
        if (filter.getSquareMin() != null) {
            query.where(room.square.gt(filter.getSquareMin()));
        }
        if (filter.getSquareMax() != null) {
            query.where(room.square.lt(filter.getSquareMax()));
        }
        if (filter.getPm2Min() != null) {
            query.where(room.square.isNotNull()
                    .and(leaseAd.price.divide(room.square).gt(filter.getPm2Min())));
        }
        if (filter.getPm2Max() != null) {
            query.where(room.square.isNotNull()
                    .and(leaseAd.price.divide(room.square).lt(filter.getPm2Max())));
        }

        result = query.fetchOne();
        return result;
    }

    @Override
    public Iterable<LeaseAd> findLeaseAdByModel(LeaseAdDto leaseAdDto) {
        Iterable<LeaseAd> result;
        Long offsetNumber = (leaseAdDto.getPaging().getCurrentPage() - 1) * leaseAdDto.getPaging().getItemsPerPage();
        String roomName = leaseAdDto.getFilter().getRoomName();

        JPAQuery<LeaseAd> query = new JPAQuery<LeaseAd>(entityManager);
        QLeaseAd leaseAd = QLeaseAd.leaseAd;
        query.select(leaseAd)
                .from(leaseAd);
        if (roomName != null && !roomName.isEmpty()) {
            query.where(leaseAd.room.name.like(Expressions.asString(roomName).concat("%")));
        }
        result = query
                .offset(offsetNumber)
                .limit(leaseAdDto.getPaging().getItemsPerPage())
                .fetchResults()
                .getResults();
        return result;
    }

    @Override
    public Long countLeaseAdByModel(LeaseAdDto leaseAdDto) {
        Long result;
        String roomName = leaseAdDto.getFilter().getRoomName();

        JPAQuery<Long> query = new JPAQuery<Long>(entityManager);
        QLeaseAd leaseAd = QLeaseAd.leaseAd;
        query.select(leaseAd.count())
                .from(leaseAd);
        if (roomName != null && !roomName.isEmpty()) {
            query.where(leaseAd.room.name.like(Expressions.asString(roomName).concat("%")));
        }

        result = query.fetchOne();
        return result;
    }
}
