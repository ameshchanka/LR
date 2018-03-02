package by.itacademy.interfaces;

import by.itacademy.entity.RoomsObjectInformation;
import org.hibernate.Session;

public interface IRoomsObjectInformationsDAO {

    public RoomsObjectInformation get(Session session, long id);

    public void create(Session session, RoomsObjectInformation item);

}
