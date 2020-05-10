package rest;

import domain.Activity;
import service.ActivityService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Stateless
@Path("activity")
public class ActivityRest {

    @Inject
    private ActivityService service;

    public ActivityRest() { }

    @TokenNeeded
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
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

    @TokenNeeded
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteActivity(Activity activity) {
        service.deleteActivity(activity);
    }

}
