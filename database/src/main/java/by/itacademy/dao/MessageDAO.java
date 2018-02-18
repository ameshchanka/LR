package by.itacademy.dao;

import by.itacademy.entity.Message;
import by.itacademy.interfaces.IMessageDAO;
import org.springframework.stereotype.Repository;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
@Repository
public class MessageDAO extends BaseDAO<Message> implements IMessageDAO {

}
