package by.itacademy.util;

import by.itacademy.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by a.meshchanka on 03.02.2018.
 */
public class EntityTestDataImporter {

    private static EntityTestDataImporter IMPORTER;

    private EntityTestDataImporter() {
    }

    public static EntityTestDataImporter getInstance() {
        if (IMPORTER == null) {
            synchronized (EntityTestDataImporter.class) {
                if (IMPORTER == null) {
                    IMPORTER = new EntityTestDataImporter();
                }
            }
        }
        return IMPORTER;
    }

    public void importTestData(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();

        Country country = new Country("Belarus");
        session.save(country);

        City city = new City("Minsk", country);
        session.save(city);

        Street street1 = new Street("Prititskogo", city);
        Street street2 = new Street("Pobediteley", city);
        session.save(street1);
        session.save(street2);

        Address address1 = new Address("65", street1);
        Address address2 = new Address("29", street2);
        session.save(address1);
        session.save(address2);

        Role roleAdmin = new Role("admin");
        Role roleManager = new Role("manager");
        Role roleUser = new Role("user");
        session.save(roleAdmin);
        session.save(roleManager);
        session.save(roleUser);

        User userAdmin = new User("NameAdmin","admin@admin.com","123456789",
                new HashSet<Role>(Arrays.asList(roleAdmin, roleManager, roleUser)));
        User userManager = new User("NameManager", "manager@mail.com", "123456789",
                new HashSet<Role>(Arrays.asList(roleManager, roleUser)));
        User user = new User("NameUser", "user@user.com", "123456789",
                new HashSet<Role>(Arrays.asList(roleUser)));
        session.save(userAdmin);
        session.save(userManager);
        session.save(user);

//
//        // addr_countries - добавляем страны
//
//        Country country = new Country(0,"Belarus");
//        dao.country.create(country);
//
//        // addr_cities - добавляем города
//        City city = new City(0,"Minsk",country.getId());
//        dao.city.create(city);
//
//        // addr_cities - добавляем улицы
//        //Pobeditelei
//        //Prititskogo
//        Street street1 = new Street(0,"Pobeditelei",city.getId());
//        dao.street.create(street1);
//        Street street2 = new Street(0,"Prititskogo",city.getId());
//        dao.street.create(street2);
//
//        // addr_addresses - добавляем адреса
//        //Pobeditelei 65
//        //Prititskogo 29
//        Address address1 = new Address(0, street1.getId(), "65");
//        dao.address.create(address1);
//
//        Address address2 = new Address(0, street2.getId(), "29");
//        dao.address.create(address2);
//
//        // ls_shoppingcenters - добавляем торговые центры
//        // Zamok //53.9307475,27.5178348
//        // Tivalli 53.908061, 27.484856
//        ShoppingCenter shoppingCenter1 = new ShoppingCenter(0, "Zamok", address1.getId(),
//                53.9307475f, 27.5178348f,
//                "Торговый центр Замок – новый уровень шопинга и развлечений! К вашим услугам" +
//                        " - магазины, кафе и рестораны, ледовый каток, кинотеатр, детский зал.");
//        dao.shoppingCenter.create(shoppingCenter1);
//
//        ShoppingCenter shoppingCenter2 = new ShoppingCenter(0, "Tivalli", address2.getId(),
//                53.908061f, 27.484856f,
//                "Современный Многофункциональный Торгово-Развлекательный Бизнес Комплекс. " +
//                        "Представляет собой мощный проект, подчёркивающий современный этап развития" +
//                        " Минска в качестве столицы европейского государства.");
//        dao.shoppingCenter.create(shoppingCenter2);
//
//        // ls_rooms - добавляем помещения
//        Room room = new Room(0, "A24", 524.6f, shoppingCenter1.getId());
//        dao.room.create(room);
//        dao.leaseRoom.create(new LeaseRoom(0, 555f,
//                new Date(new java.util.Date().getTime()),
//                null,
//                room.getId(),
//                userManager.getId()));
//
//        room = new Room(0, "B67", 324.4f, shoppingCenter1.getId());
//        dao.room.create(room);
//        dao.leaseRoom.create(new LeaseRoom(0, 450f,
//                null,
//                null,
//                room.getId(),
//                userManager.getId()));
//
//        room = new Room(0, "C31", 724.4f, shoppingCenter2.getId());
//        dao.room.create(room);
//        dao.leaseRoom.create(new LeaseRoom(0, 1500f,
//                null,
//                null,
//                room.getId(),
//                userManager.getId()));
//
//        room = new Room(0, "D15", 224.4f, shoppingCenter2.getId());
//        dao.room.create(room);
//        dao.leaseRoom.create(new LeaseRoom(0, 300f,
//                null,
//                null,
//                room.getId(),
//                userManager.getId()));

//        Organization microsoft = saveOrganization(session, "Microsoft");
//        Organization apple = saveOrganization(session, "Apple");
//        Organization google = saveOrganization(session, "Google");
//
//        Employee billGates = saveEmployee(session, "Bill", "Gates",
//                LocalDate.of(1955, Month.OCTOBER, 28), Gender.MALE, microsoft);
//        Employee steveJobs = saveEmployee(session, "Steve", "Jobs",
//                LocalDate.of(1955, Month.FEBRUARY, 24), Gender.MALE, apple);
//        Employee sergeyBrin = saveEmployee(session, "Sergey", "Brin",
//                LocalDate.of(1973, Month.AUGUST, 21), Gender.MALE, google);
//        Employee timCook = saveEmployee(session, "Tim", "Cook",
//                LocalDate.of(1960, Month.NOVEMBER, 1), Gender.MALE, apple);
//        Employee dianeGreene = saveEmployee(session, "Diane", "Greene",
//                LocalDate.of(1955, Month.JANUARY, 1), Gender.FEMALE, google);
//
//        savePayment(session, billGates, BigDecimal.valueOf(100));
//        savePayment(session, billGates, BigDecimal.valueOf(300));
//        savePayment(session, billGates, BigDecimal.valueOf(500));
//
//        savePayment(session, steveJobs, BigDecimal.valueOf(250));
//        savePayment(session, steveJobs, BigDecimal.valueOf(600));
//        savePayment(session, steveJobs, BigDecimal.valueOf(500));
//
//        savePayment(session, timCook, BigDecimal.valueOf(400));
//        savePayment(session, timCook, BigDecimal.valueOf(300));
//
//        savePayment(session, sergeyBrin, BigDecimal.valueOf(500));
//        savePayment(session, sergeyBrin, BigDecimal.valueOf(500));
//        savePayment(session, sergeyBrin, BigDecimal.valueOf(500));
//
//        savePayment(session, dianeGreene, BigDecimal.valueOf(300));
//        savePayment(session, dianeGreene, BigDecimal.valueOf(300));
//        savePayment(session, dianeGreene, BigDecimal.valueOf(300));

        session.close();
    }

//    private Organization saveOrganization(Session session, String name) {
//        Organization organization = new Organization(name);
//        session.save(organization);
//        return organization;
//    }
//
//    private Employee saveEmployee(Session session, String firstName, String lastName,
//                                  LocalDate birthday, Gender gender, Organization organization) {
//        Employee employee = new Employee(firstName, lastName, birthday, gender, organization);
//        session.save(employee);
//        return employee;
//    }
//
//    private void savePayment(Session session, Employee employee, BigDecimal amount) {
//        session.save(new Payment(amount, employee));
//    }
}
