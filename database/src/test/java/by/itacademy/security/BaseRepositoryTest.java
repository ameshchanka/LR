package by.itacademy.security;

import by.itacademy.configs.TestDatabaseConfig;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
//@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestDatabaseConfig.class)
@Transactional
public class BaseRepositoryTest {

    @Autowired
    private EntityTestDataImporter importer;
//    @Autowired
//    private EntityManagerFactory entityManagerFactory;
    @PersistenceContext
    private EntityManager entityManager;



    @Before
    public void initDb() {
        importer.importTestData(entityManager);
    }

    @After
    public void finish() {
    }

}
