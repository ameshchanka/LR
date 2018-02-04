package by.itacademy.dao;

import by.itacademy.util.EntityTestDataImporter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
public class BaseDAOTest {

    protected SessionFactory sessionFactory;
    protected EntityTestDataImporter IMPORTER = EntityTestDataImporter.getInstance();

    @Before
    public void initDb() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        IMPORTER.importTestData(sessionFactory);
    }

    @After
    public void finish() {
        sessionFactory.close();
    }
}
