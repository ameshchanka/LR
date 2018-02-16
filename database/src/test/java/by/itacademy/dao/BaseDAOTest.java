package by.itacademy.dao;

import by.itacademy.entity.City;
import by.itacademy.util.EntityTestDataImporter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
public class BaseDAOTest {

    protected static SessionFactory sessionFactory = BaseDAO.getSessionFactory();
    protected static EntityTestDataImporter IMPORTER = EntityTestDataImporter.getInstance();

    static {
        IMPORTER.importTestData(sessionFactory);
    }
    @Before
    public void initDb() {
        //sessionFactory = new Configuration().configure().buildSessionFactory();
        //sessionFactory = BaseDAO.getSessionFactory();
        //IMPORTER.importTestData(sessionFactory);
    }

    @After
    public void finish() {
        //sessionFactory.close();
    }
}
