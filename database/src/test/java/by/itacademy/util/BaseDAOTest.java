package by.itacademy.util;

import by.itacademy.config.TestDatabaseConfig;
import by.itacademy.entity.*;
import by.itacademy.util.EntityTestDataImporter;
import org.hibernate.Session;
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

import java.io.File;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = TestDatabaseConfig.class)
//@Transactional
public class BaseDAOTest {

//    public SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }

    @Autowired
    private SessionFactory sessionFactory;// = BaseDAO.getSessionFactory();

//    public BaseDAOTest() {
//    }

//    @Autowired
//    public BaseDAOTest(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//        EntityTestDataImporter.getInstance(sessionFactory);
//    }
    //protected static EntityTestDataImporter IMPORTER = EntityTestDataImporter.getInstance();
//
//    static {
//        EntityTestDataImporter
//                .getInstance()
//                .importTestData(getSessionFactory());
//    }
    @Before
    public void initDb() {
//        if(EntityTestDataImporter.getInstance().getOne() == 0) {
//            EntityTestDataImporter.getInstance().setOne(1);
//            EntityTestDataImporter
//                    .getInstance()
//                    .importTestData(sessionFactory);
//        }
        //sessionFactory = new Configuration().configure().buildSessionFactory();
        //sessionFactory = BaseDAO.getSessionFactory();
        //System.out.println("@Before  - sessionFactory");
        EntityTestDataImporter.getInstance(sessionFactory);//.importTestData(sessionFactory);
        //System.out.println("@********- sessionFactory");
//        Session session = sessionFactory.getCurrentSession();
//
//        Country country = new Country("Belarus");
//        session.save(country);
//
//        City city = new City("Minsk", country);
//        session.save(city);
//
//        Street street1 = new Street("Prititskogo", city);
//        Street street2 = new Street("Pobediteley", city);
//        Street street3 = new Street("Bobruiskaya", city);
//        Street street4 = new Street("P.Glebki", city);
//        session.save(street1);
//        session.save(street2);
//        session.save(street3);
//        session.save(street4);
//
//        Address address1 = new Address("65", street1);
//        Address address2 = new Address("29", street2);
//        Address address3 = new Address("6", street3);
//        Address address4 = new Address("5", street4);
//        session.save(address1);
//        session.save(address2);
//        session.save(address3);
//        session.save(address4);
//
//        Role roleAdmin = new Role("admin");
//        Role roleManager = new Role("manager");
//        Role roleUser = new Role("user");
//        session.save(roleAdmin);
//        session.save(roleManager);
//        session.save(roleUser);
//
//        User userAdmin = new User("NameAdmin","admin@admin.com","123456789",
//                new Contact("+375291111111","admin_skype","admin_telegram",
//                        "admin_viber"),
//                new HashSet<Role>(Arrays.asList(roleAdmin, roleManager, roleUser)));
//        User userManager = new User("NameManager", "manager@mail.com", "123456789",
//                new Contact("+375292222222","manager_skype","manager_telegram",
//                        "manager_viber"),
//                new HashSet<Role>(Arrays.asList(roleManager, roleUser)));
//        User user = new User("NameUser", "user@user.com", "123456789",
//                new Contact("+375293333333","user_skype","user_telegram",
//                        "user_viber"),
//                new HashSet<Role>(Arrays.asList(roleUser)));
//        session.save(userAdmin);
//        session.save(userManager);
//        session.save(user);
//
//        RoomsObject ro1 = new RoomsObject("Zamok" ,
//                53.9307475F, 27.5178348F, address1);
//        RoomsObject ro2 = new RoomsObject("Tivalli" ,
//                53.908061F, 27.484856F, address2);
//        RoomsObject ro3 = new RoomsObject("Galileo" , address3);
//        RoomsObjectInformation roi1 = new RoomsObjectInformation("Торговый центр Замок – " +
//                "новый уровень шопинга и развлечений! К вашим услугам - магазины, кафе и " +
//                "рестораны, ледовый каток, кинотеатр, детский зал.", ro1);
//        RoomsObjectInformation roi2 = new RoomsObjectInformation("Современный Многофункциональный" +
//                " Торгово-Развлекательный Бизнес Комплекс. Представляет собой мощный проект, подчёркивающий " +
//                "современный этап развития Минска в качестве столицы европейского государства.", ro2);
//
//        session.save(ro1);
//        session.save(ro2);
//        session.save(ro3);
//        session.save(roi1);
//        session.save(roi2);
//
//        Room r1 = new Room("A24", 524.6F, ro1, userManager);
//        Room r2 = new Room("B67", 324.4F, ro1, userManager);
//        Room r3 = new Room("C31", 724.4F, ro1, userManager);
//        Room r4 = new Room("D15", 224.4F, ro1, userManager);
//        session.save(r1);
//        session.save(r2);
//        session.save(r3);
//        session.save(r4);
//
//        LeaseAd la1 = new LeaseAd(1200.0F, r1);
//        LeaseAd la2 = new LeaseAd(700.0F, r2);
//        session.save(la1);
//        session.save(la2);
//
//        Message message1 = new Message("Hi, where i can get your phone number?",
//                LocalDateTime.now(), user, userManager, la1);
//        session.save(message1);
//
//        File f1 = createFile("img_sc_zamok001.jpg");
//        RoomsObjectImage roomsObjectImage1 = new RoomsObjectImage(f1.getName(), ro1);
//        session.save(roomsObjectImage1);
//
//        File f2 = createFile("img_sc_zamok_room001.jpg");
//        RoomImage roomImage1 = new RoomImage(f2.getName(), r1);
//        session.save(roomImage1);
    }

    @After
    public void finish() {
        //sessionFactory.close();
    }

//    private File createFile(String name) {
//        String projectDir = System.getProperty("user.dir");
//        String src = "/src/main/resources/img/";
//        String fileName = projectDir + src + name;
//        return new File(fileName);
//    }
}
