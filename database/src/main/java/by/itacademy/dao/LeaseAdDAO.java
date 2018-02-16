package by.itacademy.dao;

import by.itacademy.entity.LeaseAd;
import by.itacademy.entity.QLeaseAd;
import by.itacademy.entity.QRoom;
import by.itacademy.entity.forFilters.LeaseAdFilter;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
public class LeaseAdDAO extends BaseDAO<LeaseAd> {

    public List<LeaseAd> findLeaseByFilter(LeaseAdFilter filter) {
        SessionFactory sessionFactory = super.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<LeaseAd> result;
        JPAQuery<LeaseAd> query = new JPAQuery<>(session);
        QLeaseAd leaseAd = QLeaseAd.leaseAd;
        QRoom room = leaseAd.room;
        query.select(leaseAd)
                .from(leaseAd);
        if (filter.getPriceMin() != null) {
            query.where(leaseAd.price.gt(filter.getPriceMin()));
        }
        if (filter.getPriceMax() != null) {
            query.where(leaseAd.price.lt(filter.getPriceMax()));
        }
        if (filter.getSquareMin() != null) {
            query.where(room.square.gt(filter.getSquareMin()));
        }
        if (filter.getSquareMax() != null) {
            query.where(room.square.lt(filter.getSquareMax()));
        }
        if (filter.getPm2Min() != null) {
            query.where(room.square.isNotNull()
                    .and(leaseAd.price.divide(room.square).gt(filter.getPm2Min())));
        }
        if (filter.getPm2Max() != null) {
            query.where(room.square.isNotNull()
                    .and(leaseAd.price.divide(room.square).lt(filter.getPm2Max())));
        }

        result = query
                .offset(filter.getFirstItems())
                .limit(filter.getCountItems())
                .fetchResults()
                .getResults();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public Long countLeaseByFilter(LeaseAdFilter filter) {
        SessionFactory sessionFactory = super.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Long result;

        JPAQuery<Long> query = new JPAQuery<>(session);
        QLeaseAd leaseAd = QLeaseAd.leaseAd;
        QRoom room = leaseAd.room;
        query.select(leaseAd.count())
                .from(leaseAd);
        if (filter.getPriceMin() != null) {
            query.where(leaseAd.price.gt(filter.getPriceMin()));
        }
        if (filter.getPriceMax() != null) {
            query.where(leaseAd.price.lt(filter.getPriceMax()));
        }
        if (filter.getSquareMin() != null) {
            query.where(room.square.gt(filter.getSquareMin()));
        }
        if (filter.getSquareMax() != null) {
            query.where(room.square.lt(filter.getSquareMax()));
        }
        if (filter.getPm2Min() != null) {
            query.where(room.square.isNotNull()
                    .and(leaseAd.price.divide(room.square).gt(filter.getPm2Min())));
        }
        if (filter.getPm2Max() != null) {
            query.where(room.square.isNotNull()
                    .and(leaseAd.price.divide(room.square).lt(filter.getPm2Max())));
        }

        result = query.fetchOne();

        session.getTransaction().commit();
        session.close();
        return result;
    }
}
