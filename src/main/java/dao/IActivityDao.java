package dao;

import domain.Activity;

import java.util.List;

public interface IActivityDao {
    boolean addActivity(Activity activity);
    List<Activity> getActivities();
}
