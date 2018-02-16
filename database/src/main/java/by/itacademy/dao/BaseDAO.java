package by.itacademy.dao;

import by.itacademy.entity.BaseEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by a.meshchanka on 10.02.2018.
 */
public abstract class BaseDAO<T extends BaseEntity> implements IBaseDAO<T> {

    private Class<T> entityClass;

    private static final SessionFactory SESSION_FACTORY
            = new Configuration().configure().buildSessionFactory();

    @SuppressWarnings("unchecked")
    public BaseDAO() {
        ParameterizedType parameterizedSupperClass
                = (ParameterizedType) getClass().getGenericSuperclass();
        entityClass = (Class<T>) parameterizedSupperClass.getActualTypeArguments()[0];
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    @Override
    public Long save(T item) {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        session.save(item);

        session.getTransaction().commit();
        session.close();
        return item.getId();
    }

    @Override
    public boolean update(T item) {
        boolean result = true;
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        try {
            session.update(item);
        } catch (HibernateException e) {
            result = false;
        }

        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public boolean delete(T item) {
        boolean result = true;
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        try {
            session.delete(item);
        } catch (HibernateException e) {
            result = false;
        }

        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public T findById(Long id) {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        T result = session.get(entityClass, id);

        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public List<T> findAll(String query) {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        List<T> result = session.createQuery(query, entityClass).getResultList();

        session.getTransaction().commit();
        session.close();
        return result;
    }
}
