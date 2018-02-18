package by.itacademy.util;

import by.itacademy.config.TestDatabaseConfig;
import by.itacademy.entity.City;
import by.itacademy.util.EntityTestDataImporter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestDatabaseConfig.class)
@Transactional
public abstract class BaseDAOTest {

    @Autowired
    private SessionFactory sessionFactory;// = BaseDAO.getSessionFactory();

//    @Autowired
//    public BaseDAOTest(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
    //protected static EntityTestDataImporter IMPORTER = EntityTestDataImporter.getInstance();
//
//    static {
//        EntityTestDataImporter
//                .getInstance()
//                .importTestData();
//    }
    @Before
    public void initDb() {
        if(EntityTestDataImporter.getInstance().getOne() == 0) {
            EntityTestDataImporter.getInstance().setOne(1);
            EntityTestDataImporter
                    .getInstance()
                    .importTestData(sessionFactory);
        }
        //sessionFactory = new Configuration().configure().buildSessionFactory();
        //sessionFactory = BaseDAO.getSessionFactory();
        //IMPORTER.importTestData(sessionFactory);
    }

    @After
    public void finish() {
        //sessionFactory.close();
    }
}
