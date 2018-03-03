package by.itacademy.util;

import by.itacademy.config.TestDatabaseConfig;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
//@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestDatabaseConfig.class)
@Transactional
public class BaseRepositoryTest {

    @Autowired
    private EntityTestDataImporter importer;
    @Autowired
    private EntityManagerFactory entityManagerFactory;


    @Before
    public void initDb() {
        importer.importTestData(entityManagerFactory);
    }

    @After
    public void finish() {
    }

}
