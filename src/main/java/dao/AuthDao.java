package dao;

import domain.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class AuthDao implements IAuthDao {

    private final EntityManager em;

    public AuthDao(EntityManager em) {
        this.em = em;
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
}
