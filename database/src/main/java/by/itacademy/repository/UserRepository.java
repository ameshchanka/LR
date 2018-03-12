package by.itacademy.repository;

import by.itacademy.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("select e from User e where e.email=?1")
    User findByEmail(String email);

}
