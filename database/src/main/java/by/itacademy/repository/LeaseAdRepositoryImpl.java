package by.itacademy.repository;

import by.itacademy.entity.LeaseAd;
import by.itacademy.entity.QLeaseAd;
import by.itacademy.entity.QRoom;
import by.itacademy.entity.forFilters.LeaseAdFilter;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class LeaseAdRepositoryImpl implements LeaseAdRepositoryCustom {

    private EntityManagerFactory entityManagerFactory;

    @Autowired
    public LeaseAdRepositoryImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public List<LeaseAd> findLeaseByFilter(LeaseAdFilter filter) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<LeaseAd> result;
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
                .offset(filter.getFirstItems())
                .limit(filter.getCountItems())
                .fetchResults()
                .getResults();
        return result;
    }

    public Long countLeaseByFilter(LeaseAdFilter filter) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Long result;

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
}
