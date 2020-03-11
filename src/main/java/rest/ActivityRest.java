package rest;

import domain.Activity;
import service.ActivityService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("activity")
public class ActivityRest {
    private ActivityService service = new ActivityService();
    public ActivityRest() { }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String addActivity(Activity activity) {
        return service.addActivity(activity);
    }

    @GET
    public List<Activity> getActivities() {
        return service.getActivities();
    }
}
