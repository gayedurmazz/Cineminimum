package com.uniyaz.cinema.dao;

import com.uniyaz.cinema.domain.User;
import com.uniyaz.cinema.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class UserDao {

    public User saveUser(User user) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            session.getTransaction().begin();
            user = (User) session.merge(user);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return user;
    }

    public List<User> findAllUsers() {
        List<User> userList = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            String hql = "Select user From User user";
            Query query = session.createQuery(hql);
            userList = query.list();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return userList;
    }
}
