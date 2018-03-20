package by.itacademy.repository;

import by.itacademy.entity.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    @Cacheable(key = "#root.args[0]", cacheNames = "lease")
    @Query("select e from User e where e.email=?1")
    User findByEmail(String email);
}
