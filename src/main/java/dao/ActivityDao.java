package dao;

import domain.Activity;
import domain.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.PathParam;
import java.util.List;

public class ActivityDao implements IActivityDao {
    private final EntityManager em;
    public ActivityDao(EntityManager em) {
        this.em = em;
    }

    public boolean addActivity(Activity activity) {
        em.getTransaction().begin();
        try {
            em.persist(activity);
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

    public List<Activity> getActivities() {
        List<Activity> activities = null;
        em.getTransaction().begin();
        try {
            Query query = em.createQuery("select a from Activity a");
            activities = query.getResultList();
            em.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
        return activities;
    }

}
