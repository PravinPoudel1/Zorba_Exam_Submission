package com.springmvcexam.dao;

import com.springmvcexam.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImplement implements UserDao {

    private SessionFactory sessionFactory;

    //constructor DI
    public UserDaoImplement(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public String saveUser(User user) {
        String string = "";
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.persist(user);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return string;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        String userQuery = "FROM User";
        try {
            Query query = session.createQuery(userQuery);
            users = query.list();
            tx.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return users;

    }

    @Override
    public User getUserById(Integer userId) {

        User user = new User();
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        String studentQuery = "FROM User u where u.userId = :userId";
        try {
            Query query = session.createQuery(studentQuery);
            query.setInteger("userId", userId);
            user = (User) query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return user;
    }

}
