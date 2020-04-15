package dao;

import domain.User;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


public class UserDao implements IUserDao {

    private final EntityManager em;

    public UserDao(EntityManager em) {
        this.em = em;
    }


    public List<User> getUsers() {
        List<User> users = null;
        em.getTransaction().begin();
        try {
            Query query = em.createQuery("select u from User u");
            users = query.getResultList();
            em.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
        return users;
    }

    public User getUser(long uid) {
        User user = null;
        em.getTransaction().begin();
        try
        {
            Query query = em.createQuery("select u from User u where u.id = :uid").setParameter("uid", uid);
            user = (User) query.getSingleResult();
            em.getTransaction().commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
        return user;
    }

    public boolean register(User u) {
        em.getTransaction().begin();
        try {
            em.persist(u);
            em.getTransaction().commit();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        }
        finally {
            em.close();
        }
    }

    public boolean editUser(User u) {
        em.getTransaction().begin();
        try {
            em.merge(u);
            em.getTransaction().commit();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        }
        finally {
            em.close();
        }
    }

    public long getIdForName(String username) {
        long id = 0;
        em.getTransaction().begin();
        try
        {
            Query query = em.createQuery("select u.id from User u where u.username = :username").setParameter("username", username);
            id = (long) query.getSingleResult();
            em.getTransaction().commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
        return id;
    }

    public String getPassword(Long id) {
        String hashpw = "";
        em.getTransaction().begin();
        try
        {
            Query query = em.createQuery("select u.password from User u where u.id = :uid").setParameter("uid", id);
            hashpw = (String) query.getSingleResult();
            em.getTransaction().commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
        return hashpw;
    }

    public boolean CheckIfAlreadyExists(User user) {
        em.getTransaction().begin();
        long u = 0;
        try
        {
            Query query = em.createQuery("select count(u.username) from User u where u.username = :username").setParameter("username", user.getUsername());
            u = (long) query.getSingleResult();
            em.getTransaction().commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        finally {
            em.close();
            return u == 1;
        }
    }
}

