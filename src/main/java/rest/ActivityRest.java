package rest;

import domain.Activity;
import domain.User;
import service.ActivityService;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Stateless
@Path("activity")
public class ActivityRest {
    private ActivityService service = new ActivityService();
    public ActivityRest() { }

    @TokenNeeded
    @POST
    public void addActivity(Activity activity) {
        service.addActivity(activity);
    }

    @TokenNeeded
    @GET
    public List<Activity> getActivities(@QueryParam("userId") long id) {
        return service.getActivities(id);
    }

    @Path("/{id}")
    @TokenNeeded
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void editActivity(@PathParam("id") long id, Activity activity) {
        activity.setId(id);
        service.editActivity(activity);
    }

    // Delete activity
}
