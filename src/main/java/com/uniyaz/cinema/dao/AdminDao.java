package com.uniyaz.cinema.dao;

import com.uniyaz.cinema.domain.Movie;
import com.uniyaz.cinema.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class AdminDao {

    public Movie saveMovie(Movie movie) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            session.getTransaction().begin();
            movie = (Movie) session.merge(movie);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return movie;
    }

    public List<Movie> findAllMovies() {
        List<Movie> movieList = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            String hql = "Select movie From Movie movie";
            Query query = session.createQuery(hql);
            movieList = query.list();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return movieList;
    }


}
