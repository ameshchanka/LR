package by.itacademy.dao;

import by.itacademy.entity.RoomsObject;
import by.itacademy.entity.RoomsObjectInformation;
import by.itacademy.interfaces.IRoomsObjectInformationsDAO;
import by.itacademy.util.BaseDAOTest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
@RunWith(SpringRunner.class)
public class RoomsObjectInformationDAOTest extends BaseDAOTest {

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private IRoomsObjectInformationsDAO roomsObjectInformationsDAO;

    @Test
    public void get() {
        Session session = sessionFactory.getCurrentSession();

        RoomsObjectInformation item =
                roomsObjectInformationsDAO.get(session, 1L);
        assertThat(item.getRoomsObject().getName(), equalTo("Zamok"));
    }

    @Test
    public void create() {
        Session session = sessionFactory.getCurrentSession();

        RoomsObject temp = session.get(RoomsObject.class, 3L);
        RoomsObjectInformation item = new RoomsObjectInformation(
                "Многофункциональный торгово-развлекательный комплекс, " +
                        "современный формат которого позволяет объединить возможности " +
                        "для комфортного шопинга и насыщенного досуга.", temp);
        roomsObjectInformationsDAO.create(session, item);
        RoomsObjectInformation result = session.get(RoomsObjectInformation.class, 3L);
        assertThat(result.getRoomsObject().getName(), equalTo("Galileo"));
    }
}