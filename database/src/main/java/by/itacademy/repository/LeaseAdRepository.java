package by.itacademy.repository;

import by.itacademy.entity.LeaseAd;
import org.springframework.data.repository.CrudRepository;

public interface LeaseAdRepository extends CrudRepository<LeaseAd, Long>, LeaseAdRepositoryCustom {

}
