package by.itacademy.testerror;

import by.itacademy.util.BaseDAOTest;

import static org.junit.Assert.assertThat;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
public class RoomsObjectInformationDAOTest extends BaseDAOTest {

//    @Test
//    public void get() throws Exception {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        RoomsObjectInformation item =
//                DAO.getInstance().getRoomsObjectInformationsDAO().get(session, 1L);
//        assertThat(item.getRoomsObject().getName(), equalTo("Zamok"));
//
//        session.getTransaction().commit();
//        session.close();
//    }
//
//    @Test
//    public void create() throws Exception {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        RoomsObject temp = session.get(RoomsObject.class, 3L);
//        RoomsObjectInformation item = new RoomsObjectInformation(
//                "Многофункциональный торгово-развлекательный комплекс, " +
//                        "современный формат которого позволяет объединить возможности " +
//                        "для комфортного шопинга и насыщенного досуга.", temp);
//        DAO.getInstance().getRoomsObjectInformationsDAO().create(session, item);
//        RoomsObjectInformation result = session.get(RoomsObjectInformation.class, 3L);
//        assertThat(result.getRoomsObject().getName(), equalTo("Galileo"));
//
//        session.getTransaction().commit();
//        session.close();
//    }
}