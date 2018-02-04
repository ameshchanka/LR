package by.itacademy.dao;

import by.itacademy.entity.RoomsObject;
import by.itacademy.entity.RoomsObjectInformation;
import org.hibernate.Session;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
public class RoomsObjectInformationDAOTest extends BaseDAOTest {

    @Test
    public void get() throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        RoomsObjectInformation item =
                DAO.getInstance().roomsObjectInformationsDAO.get(session, 1L);
        assertThat(item.getRoomsObject().getName(), equalTo("Zamok"));

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void create() throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        RoomsObject temp = session.get(RoomsObject.class, 3L);
        RoomsObjectInformation item = new RoomsObjectInformation(
                "Многофункциональный торгово-развлекательный комплекс, " +
                        "современный формат которого позволяет объединить возможности " +
                        "для комфортного шопинга и насыщенного досуга.", temp);
        DAO.getInstance().roomsObjectInformationsDAO.create(session, item);
        RoomsObjectInformation result = session.get(RoomsObjectInformation.class, 3L);
        assertThat(result.getRoomsObject().getName(), equalTo("Galileo"));

        session.getTransaction().commit();
        session.close();
    }
}