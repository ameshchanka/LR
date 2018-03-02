package by.itacademy.dao;

import by.itacademy.entity.RoomsObjectInformation;
import by.itacademy.interfaces.IRoomsObjectInformationsDAO;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
@Repository
public class RoomsObjectInformationsDAO implements IRoomsObjectInformationsDAO {

    @Override
    public RoomsObjectInformation get(Session session, long id) {
        return session.get(RoomsObjectInformation.class, id);
    }

    public void create(Session session, RoomsObjectInformation item) {
        session.save(item);
    }
}
