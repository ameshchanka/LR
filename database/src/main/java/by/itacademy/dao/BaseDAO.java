package by.itacademy.dao;

import by.itacademy.entity.BaseEntity;
import by.itacademy.interfaces.IBaseDAO;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by a.meshchanka on 10.02.2018.
 */
public abstract class BaseDAO<T extends BaseEntity> implements IBaseDAO<T> {

    private Class<T> entityClass;

//    private static final SessionFactory SESSION_FACTORY
//            = new Configuration().configure().buildSessionFactory();
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public BaseDAO() {
        ParameterizedType parameterizedSupperClass
                = (ParameterizedType) getClass().getGenericSuperclass();
        entityClass = (Class<T>) parameterizedSupperClass.getActualTypeArguments()[0];
    }

    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public Long save(T item) {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();

        sessionFactory.getCurrentSession().save(item);

//        session.getTransaction().commit();
//        session.close();
        return item.getId();
    }

    @Override
    public boolean update(T item) {
        boolean result = true;
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();

        try {
//            session.update(item);
            sessionFactory.getCurrentSession().update(item);
        } catch (HibernateException e) {
            result = false;
        }

//        session.getTransaction().commit();
//        session.close();
        return result;
    }

    @Override
    public boolean delete(T item) {
        boolean result = true;
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();

        try {
//            session.delete(item);
            sessionFactory.getCurrentSession().delete(item);
        } catch (HibernateException e) {
            result = false;
        }

//        session.getTransaction().commit();
//        session.close();
        return result;
    }

    @Override
    public T findById(Long id) {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();

//        T result = session.get(entityClass, id);
        T result = sessionFactory.getCurrentSession().get(entityClass, id);
//        session.getTransaction().commit();
//        session.close();
        return result;
    }

    @Override
    public List<T> findAll(String query) {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();

//        List<T> result = session.createQuery(query, entityClass).getResultList();
        List<T> result = sessionFactory
                .getCurrentSession()
                .createQuery(query, entityClass)
                .getResultList();
//        session.getTransaction().commit();
//        session.close();
        return result;
    }
}
