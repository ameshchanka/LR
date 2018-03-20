package by.itacademy.repository;

import by.itacademy.entity.QRoom;
import by.itacademy.entity.QRoomsObject;
import by.itacademy.entity.RoomsObject;
import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class RoomsObjectRepositoryImpl implements RoomsObjectRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<RoomsObject> findAllWithRooms() {
        List<RoomsObject> result;
        JPAQuery<RoomsObject> query = new JPAQuery<RoomsObject>(entityManager);
        QRoomsObject roomsObject = QRoomsObject.roomsObject;
        QRoom room = QRoom.room;

        query.select(roomsObject)
                .from(roomsObject)
                .innerJoin(roomsObject.rooms, room)
                .fetchJoin()
                .groupBy(roomsObject.id);
        result = query
                .fetchResults()
                .getResults();
        return result;
    }
}
