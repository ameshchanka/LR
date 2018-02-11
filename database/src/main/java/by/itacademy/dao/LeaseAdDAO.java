package by.itacademy.dao;

import by.itacademy.entity.LeaseAd;
import by.itacademy.entity.forFilters.LeaseAdFilter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
public class LeaseAdDAO extends BaseDAO<LeaseAd> {

    public List<LeaseAd> findLeaseByFilter(LeaseAdFilter filter) {
        SessionFactory SESSION_FACTORY = super.getSessionFactory();
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();
        List<LeaseAd> result;
        Query<LeaseAd> query = session
                .createQuery("select e from LeaseAd e " +
                        "where e.price between :priceMin and :priceMax and " +
                        "e.room.square between :squareMin and :squareMax and " +
                        "e.price/e.room.square between :pm2Min and :pm2Max", LeaseAd.class)
                .setParameter("priceMin", filter.getPriceMin())
                .setParameter("priceMax", filter.getPriceMax())
                .setParameter("squareMin", filter.getSquareMin())
                .setParameter("squareMax", filter.getSquareMax())
                .setParameter("pm2Min", filter.getPm2Min())
                .setParameter("pm2Max", filter.getPm2Max())
                .setMaxResults(filter.getMaxResult())
                .setFirstResult(filter.getFirstResult());
        result =  query.getResultList();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public Long countLeaseByFilter(LeaseAdFilter filter) {
        SessionFactory SESSION_FACTORY = super.getSessionFactory();
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();
        Long result;
        Query<Long> query = session
                .createQuery("select count(e) from LeaseAd e " +
                        "where e.price between :priceMin and :priceMax and " +
                        "e.room.square between :squareMin and :squareMax and " +
                        "e.price/e.room.square between :pm2Min and :pm2Max", Long.class)
                .setParameter("priceMin", filter.getPriceMin())
                .setParameter("priceMax", filter.getPriceMax())
                .setParameter("squareMin", filter.getSquareMin())
                .setParameter("squareMax", filter.getSquareMax())
                .setParameter("pm2Min", filter.getPm2Min())
                .setParameter("pm2Max", filter.getPm2Max());
        result =  query.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return result;
    }
}
