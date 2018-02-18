package by.itacademy.dao;

import by.itacademy.entity.Address;
import by.itacademy.interfaces.IAddressDAO;
import org.springframework.stereotype.Repository;

/**
 * @author a.meshchanka on 03.02.2018.
 */
@Repository
public class AddressDAO extends BaseDAO<Address> implements IAddressDAO {

}
