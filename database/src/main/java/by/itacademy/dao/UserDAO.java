package by.itacademy.dao;

import by.itacademy.entity.User;
import by.itacademy.interfaces.IUserDAO;
import org.springframework.stereotype.Repository;

/**
 * Created by a.meshchanka on 03.02.2018.
 */
@Repository
public class UserDAO extends BaseDAO<User> implements IUserDAO {

}
