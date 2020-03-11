package service;

import dao.ActivityDao;
import dao.IActivityDao;
import dao.IUserDao;
import domain.Activity;

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

    public List<Activity> getActivities() {
        EntityManager em = emf.createEntityManager();
        dao = new ActivityDao(em);
        return dao.getActivities();
    }
}
