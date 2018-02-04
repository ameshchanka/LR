package by.itacademy.dao;

import by.itacademy.entity.*;

/**
 * Created by a.meshchanka on 03.02.2018.
 */
public final class DAO {

    private static DAO dao;

    public AddressDAO addressDAO;
//    public CityDAO cityDAO;
//    public CountryDAO countryDAO;
//    public ImageDAO imageDAO;
//    public LeaseAdDAO leaseAdDAO;
//    public MessageDAO messageDAO;
    public RoleDAO roleDAO;
//    public RoomDAO roomDAO;
//    public RoomImageDAO roomImageDAO;
//    public RoomsObjectDAO roomsObjectDAO;
//    public RoomsObjectImageDAO roomsObjectImageDAO;
//    public RoomsObjectInformationsDAO roomsObjectInformationsDAO;
//    public StreetDAO streetDAO;
    public UserDAO userDAO;

    private DAO() {

    }

    public static DAO getInstance() {
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.addressDAO = new AddressDAO();
//                    dao.cityDAO = new CityDAO();
//                    dao.countryDAO = new CountryDAO();
//                    dao.imageDAO = new ImageDAO();
//                    dao.leaseAdDAO = new LeaseAdDAO();
//                    dao.messageDAO = new MessageDAO();
                    dao.roleDAO = new RoleDAO();
//                    dao.roomDAO = new RoomDAO();
//                    dao.roomImageDAO = new RoomImageDAO();
//                    dao.roomsObjectDAO = new RoomsObjectDAO();
//                    dao.roomsObjectImageDAO = new RoomsObjectImageDAO();
//                    dao.roomsObjectInformationsDAO = new RoomsObjectInformationsDAO();
//                    dao.streetDAO = new StreetDAO();
                    dao.userDAO = new UserDAO();
                }
            }
        }
        return dao;
    }
}
