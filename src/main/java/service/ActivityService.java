package service;

import dao.ActivityDao;
import dao.IActivityDao;
import dao.IUserDao;
import dao.UserDao;
import domain.Activity;
import domain.User;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Stateless
public class ActivityService {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("compagendaPU");
    private IActivityDao dao;

    public boolean addActivity(Activity activity) {
        EntityManager em = emf.createEntityManager();
        dao = new ActivityDao(em);
        return (dao.addActivity(activity));
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

    public boolean deleteActivity(Activity activity) {
        EntityManager em = emf.createEntityManager();
        dao = new ActivityDao(em);
        return dao.deleteActivity(activity);
    }
}
