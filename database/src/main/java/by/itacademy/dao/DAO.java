package by.itacademy.dao;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by a.meshchanka on 03.02.2018.
 */
public final class DAO {

    private static DAO dao;

    @Getter
    @Setter
    private AddressDAO addressDAO;
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private CityDAO cityDAO;
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private CountryDAO countryDAO;
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private LeaseAdDAO leaseAdDAO;
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private MessageDAO messageDAO;
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private RoleDAO roleDAO;
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private RoomDAO roomDAO;
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private RoomImageDAO roomImageDAO;
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private RoomsObjectDAO roomsObjectDAO;
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private RoomsObjectImageDAO roomsObjectImageDAO;
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private RoomsObjectInformationsDAO roomsObjectInformationsDAO;
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private StreetDAO streetDAO;
    @Getter
    @Setter
    private UserDAO userDAO;

    private DAO() {

    }

    public static DAO getInstance() {
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.setAddressDAO(new AddressDAO());
                    dao.cityDAO = new CityDAO();
                    dao.countryDAO = new CountryDAO();
                    dao.leaseAdDAO = new LeaseAdDAO();
                    dao.messageDAO = new MessageDAO();
                    dao.roleDAO = new RoleDAO();
                    dao.roomDAO = new RoomDAO();
                    dao.roomImageDAO = new RoomImageDAO();
                    dao.roomsObjectDAO = new RoomsObjectDAO();
                    dao.roomsObjectImageDAO = new RoomsObjectImageDAO();
                    dao.roomsObjectInformationsDAO = new RoomsObjectInformationsDAO();
                    dao.streetDAO = new StreetDAO();
                    dao.setUserDAO(new UserDAO());
                }
            }
        }
        return dao;
    }
}
