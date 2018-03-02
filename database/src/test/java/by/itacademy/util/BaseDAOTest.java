package by.itacademy.util;

import by.itacademy.config.TestDatabaseConfig;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
//@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestDatabaseConfig.class)
@Transactional
public class BaseDAOTest {

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private EntityTestDataImporter importer;

    @Before
    public void initDb() {
        importer.importTestData(sessionFactory);
    }

    @After
    public void finish() {
    }

}
