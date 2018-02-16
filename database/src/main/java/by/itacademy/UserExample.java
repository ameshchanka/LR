package by.itacademy;

import by.itacademy.dao.DAO;
import by.itacademy.entity.User;

/**
 * Created by a.meshchenko on 21.01.2018.
 */
public class UserExample {

    public User getFirstUser() {

        User item = DAO.getInstance().getUserDAO().findById(1L);
        return item;
    }
}
