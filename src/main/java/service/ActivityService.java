package service;

import dao.ActivityDao;
import dao.IActivityDao;
import dao.IUserDao;
import dao.UserDao;
import domain.Activity;
import domain.User;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ActivityService {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("compagendaPU");
    private IActivityDao dao;

    public String addActivity(Activity activity) {
        EntityManager em = emf.createEntityManager();
        dao = new ActivityDao(em);
        if(dao.addActivity(activity)) {
            return "Added acitivity";
        }
        else {
            return "Failed to add activity";
        }
    }

    public List<Activity> getActivities(long id) {
        EntityManager em = emf.createEntityManager();
        dao = new ActivityDao(em);
        return dao.getActivities(id);
    }

    public String editActivity(Activity activity) {
        EntityManager em = emf.createEntityManager();
        dao = new ActivityDao(em);
        if(dao.editActivity(activity)) {
            return "Successfully edited activity";
        }
        else {
            return "Error while editing activity";
        }
    }

    public void deleteActivity(Activity activity) {
        EntityManager em = emf.createEntityManager();
        dao = new ActivityDao(em);
        dao.deleteActivity(activity);
    }
}
