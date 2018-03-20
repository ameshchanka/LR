package by.itacademy.security;

import by.itacademy.entity.*;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.File;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;

public class EntityTestDataImporter {

    private static int onlyOneImportTestData = 0;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void importTestData(EntityManager entityManager) {
        if (EntityTestDataImporter.onlyOneImportTestData == 0) {
            EntityTestDataImporter.onlyOneImportTestData ++;

            //EntityManager entityManager = entityManagerFactory.createEntityManager();
            //entityManager.getTransaction().begin();
            //entityManager.joinTransaction();

            Country country = new Country("Belarus");
            entityManager.persist(country);

            City city = new City("Minsk", country);
            entityManager.persist(city);

            Street street1 = new Street("Prititskogo", city);
            Street street2 = new Street("Pobediteley", city);
            Street street3 = new Street("Bobruiskaya", city);
            Street street4 = new Street("P.Glebki", city);
            if (entityManager.find(Street.class, 1L) == null) {
                entityManager.persist(street1);
                System.out.println(entityManager.find(Street.class, 1L));
                entityManager.persist(street2);
                entityManager.persist(street3);
                entityManager.persist(street4);
            }

            Address address1 = new Address("65", street1);
            Address address2 = new Address("29", street2);
            Address address3 = new Address("6", street3);
            Address address4 = new Address("5", street4);
            entityManager.persist(address1);
            entityManager.persist(address2);
            entityManager.persist(address3);
            entityManager.persist(address4);

            Role roleAdmin = new Role("admin");
            Role roleManager = new Role("manager");
            Role roleUser = new Role("user");
            entityManager.persist(roleAdmin);
            entityManager.persist(roleManager);
            entityManager.persist(roleUser);

            User userAdmin = new User("NameAdmin", "admin@admin.com", "123456789",
                    new Contact("+375291111111", "admin_skype", "admin_telegram",
                            "admin_viber"),
                    new HashSet<Role>(Arrays.asList(roleAdmin, roleManager, roleUser)));
            User userManager = new User("NameManager", "manager@mail.com", "123456789",
                    new Contact("+375292222222", "manager_skype", "manager_telegram",
                            "manager_viber"),
                    new HashSet<Role>(Arrays.asList(roleManager, roleUser)));
            User user = new User("NameUser", "user@user.com", "123456789",
                    new Contact("+375293333333", "user_skype", "user_telegram",
                            "user_viber"),
                    new HashSet<Role>(Arrays.asList(roleUser)));
            entityManager.persist(userAdmin);
            entityManager.persist(userManager);
            entityManager.persist(user);

            RoomsObject ro1 = new RoomsObject("Zamok",
                    53.9307475F, 27.5178348F, address1);
            RoomsObject ro2 = new RoomsObject("Tivalli",
                    53.908061F, 27.484856F, address2);
            RoomsObject ro3 = new RoomsObject("Galileo", address3);
            entityManager.persist(ro1);
            entityManager.persist(ro2);
            entityManager.persist(ro3);

            RoomsObjectInformation roi1 = new RoomsObjectInformation("Торговый центр Замок – " +
                    "новый уровень шопинга и развлечений! К вашим услугам - магазины, кафе и " +
                    "рестораны, ледовый каток, кинотеатр, детский зал.", ro1);
            RoomsObjectInformation roi2 = new RoomsObjectInformation("Современный Многофункциональный" +
                    " Торгово-Развлекательный Бизнес Комплекс. Представляет собой мощный проект, подчёркивающий " +
                    "современный этап развития Минска в качестве столицы европейского государства.", ro2);
            entityManager.persist(roi1);
            entityManager.persist(roi2);

            Room r1 = new Room("A24", 524.6F, ro1, userManager);
            Room r2 = new Room("B67", 324.4F, ro1, userManager);
            Room r3 = new Room("C31", 724.4F, ro1, userManager);
            Room r4 = new Room("D15", 224.4F, ro1, userManager);
            entityManager.persist(r1);
            entityManager.persist(r2);
            entityManager.persist(r3);
            entityManager.persist(r4);

            LeaseAd la1 = new LeaseAd(1200.0F, r1);
            LeaseAd la2 = new LeaseAd(700.0F, r2);
            entityManager.persist(la1);
            entityManager.persist(la2);

            Message message1 = new Message("Hi, where i can get your phone number?",
                    LocalDateTime.now(), user, userManager, la1);
            entityManager.persist(message1);

            File f1 = createFile("img_sc_zamok001.jpg");
            RoomsObjectImage roomsObjectImage1 = new RoomsObjectImage(f1.getName(), ro1);
            entityManager.persist(roomsObjectImage1);

            File f2 = createFile("img_sc_zamok_room001.jpg");
            RoomImage roomImage1 = new RoomImage(f2.getName(), r1);
            entityManager.persist(roomImage1);

            //entityManager.getTransaction().commit();
            //entityManager.close();
            }
        }

        public File createFile (String name){
            String projectDir = System.getProperty("user.dir");
            String src = "/src/main/resources/img/";
            String fileName = projectDir + src + name;
            return new File(fileName);
        }
    }
