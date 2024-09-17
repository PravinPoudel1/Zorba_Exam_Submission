package com.springmvcexam.dao;

import com.springmvcexam.entity.Role;
import com.springmvcexam.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserDAOImpl {

    private final SessionFactory sessionFactory;

    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public boolean saveUser (User user) {
        boolean result = true;
        Session session = sessionFactory.getCurrentSession();
        try {
            session.persist(user);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Transactional
    public boolean updateUser (User user) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.update(user);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Transactional(readOnly = true)
    public User getUser (Integer id) {
        User user= null;
        Session session = sessionFactory.getCurrentSession();
        String hql= "from User where userId= :id";
        try {
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            user = (User) query.uniqueResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return user;
        }
        return user;
    }

    @Transactional(readOnly = true)
    public User getUser (String username, String password) {
        User user= null;
        Session session = sessionFactory.getCurrentSession();
        String hql= "from User where username= :username and userPass= :password";
        try {
            Query query = session.createQuery(hql);
            query.setParameter("username", username);
            query.setParameter("password", password);
            user = (User) query.uniqueResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return user;
        }
        return user;
    }



    @Transactional(readOnly = true)
    public Role getRole(Integer roleId) {
        Session session = sessionFactory.getCurrentSession();
        Role role= null;
        String hql= "from Role where roleId= :roleId";
        try{
            Query query = session.createQuery(hql);
            query.setParameter("roleId", roleId);
            role = (Role) query.uniqueResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return role;
        }
        return role;
    }


    @Transactional(readOnly = true)
    public Role getRole(String roleName) {
        Session session = sessionFactory.getCurrentSession();
        Role role= null;
        String hql= "from Role where roleName = :roleName";
        try{
            Query query = session.createQuery(hql);
            query.setParameter("roleName", roleName);
            role = (Role) query.uniqueResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return role;
        }
        return role;
    }




    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        List <User> users;
        Session session = sessionFactory.getCurrentSession();
        String query= "from User";
        try {
            users =  session.createQuery(query).list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return users;
    }

    @Transactional(readOnly = true)
    public List<Role> getAllRoles() {
        List <Role> roles;
        Session session = sessionFactory.getCurrentSession();
        String query= "from Role";
        try {
            roles = session.createQuery(query).list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return roles;
    }

    @Transactional
    public User removeRole(Integer roleId, Integer userId) {
        Session session = sessionFactory.getCurrentSession();
        try {
            User user = (User) session.get(User.class, userId);
            Role role = (Role) session.get(Role.class, roleId);
            user.getRoles().remove(role);
            return user;
        } catch (Exception e) {
            System.err.println("Unable to delete the doctor: " + e.getMessage());
            return null;
        }
    }
}
