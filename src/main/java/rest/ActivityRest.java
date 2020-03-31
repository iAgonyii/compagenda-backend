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

    @POST
    public void addActivity(Activity activity) {
        service.addActivity(activity);
    }

    @GET
    public List<Activity> getActivities(@QueryParam("userId") long id) {
        return service.getActivities(id);
    }

    @Path("/{id}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void editActivity(@PathParam("id") long id, Activity activity) {
        activity.setId(id);
        service.editActivity(activity);
    }
}
