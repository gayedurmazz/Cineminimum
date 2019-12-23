package com.uniyaz.cinema.dao;

import com.uniyaz.cinema.domain.User;
import com.uniyaz.cinema.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class UserDao {

    private String userName;
    private String password;

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

    public boolean isLoginAllowed(String userName,String password){
        this.userName = userName;
        this.password = password;

        boolean isAllowed = false;

        List<User> userList = findAllUsers();

        for (User user : userList) {
            if(userName.equals( user.getUserName()) && password.equals(user.getPassword())){
                isAllowed = true;
                break;
            }
        }
        return isAllowed;
    }
}
