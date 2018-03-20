package by.itacademy.repository;

import by.itacademy.entity.QLeaseAd;
import by.itacademy.entity.QRoom;
import by.itacademy.entity.Room;
import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class RoomRepositoryImpl implements RoomRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Room> findRoomsByUserEmail(String email) {
        List<Room> result;
        JPAQuery<Room> query = new JPAQuery<Room>(entityManager);
        QRoom room = QRoom.room;
        QLeaseAd leaseAd = QLeaseAd.leaseAd;

        query.select(room)
                .from(room)
                .leftJoin(room.leaseAds, leaseAd)
                .fetchJoin()
                .where(leaseAd.dateStopLease.isNull())
                .where(room.user.email.eq(email));
        result = query
                .fetchResults()
                .getResults();
        return result;
    }

    @Override
    public List<Room> findByRoomsObject(Long id) {
//        List<Room> result;
//        JPAQuery<Room> query = new JPAQuery<Room>(entityManager);
//        QRoom room = QRoom.room;
//
//        query.select(room)
//                .from(room)
//                .where(room.roomsObject.id.eq(id));
//        result = query
//                .fetchResults()
//                .getResults();
        List<Room> result;
        JPAQuery<Room> query = new JPAQuery<Room>(entityManager);
        QRoom room = QRoom.room;
        QLeaseAd leaseAd = QLeaseAd.leaseAd;

        query.select(room)
                .from(room)
                .innerJoin(room.leaseAds, leaseAd)
                .fetchJoin()
                .where(leaseAd.dateStartLease.isNull()
                        .and(leaseAd.dateStopLease.isNull()))
                .where(room.roomsObject.id.eq(id));
        result = query
                .fetchResults()
                .getResults();
        return result;
    }
}
