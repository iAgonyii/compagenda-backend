package Services;

import domain.Activity;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import service.ActivityService;
import service.AuthService;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ActivityTests {
    ActivityService service = new ActivityService();
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("compagendaPU");

    @BeforeClass
    public static void cleanUsersDB() {
        //DatabaseCleaner cleaner = new DatabaseCleaner(emf.createEntityManager());
        //cleaner.deleteUser("testUser");
    }


    @Test
    public void a_AddActivity() {
        Activity activity = new Activity("Testing", LocalDateTime.parse("2020-04-30T12:00"), LocalDateTime.parse("2020-04-30T13:00"), (long) 1);
        boolean success = service.addActivity(activity);

        assertTrue(success);
    }

    @Test
    public void b_GetActivities() {
        List<Activity> activities = service.getActivities(1);

        assertEquals("Testing", activities.get(0).getCategory());
    }

    @Test
    public void c_EditActivity() {
        List<Activity> activities;
        activities = service.getActivities(1);
        Activity activity = activities.get(0);
        activity.setCategory("TestingEdit");

        service.editActivity(activity);
        activities = service.getActivities(1);

        assertEquals("TestingEdit", activities.get(0).getCategory());
    }

    @Test
    public void d_DeleteActivity() {
        List<Activity> activities = service.getActivities(1);
        Activity activity = activities.get(0);

        boolean deleted = service.deleteActivity(activity);

        assertTrue(deleted);
    }

}
