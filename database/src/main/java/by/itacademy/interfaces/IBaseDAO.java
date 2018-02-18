package by.itacademy.interfaces;

import by.itacademy.entity.BaseEntity;
import java.util.List;

public interface IBaseDAO<T extends BaseEntity> {

    Long save(T item);
    boolean update(T item);
    boolean delete(T item);
    T findById(Long id);
    List<T> findAll(String query);
}
