package rest;

import domain.User;
import service.UserService;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Stateless
@Path("users")
public class UserRest
{
    private UserService service = new UserService();

    public UserRest() {

    }

    @Path("/{uid}")
    @GET
    public User getUser(@PathParam("uid") long uid) {
        /*service = new UserService();*/
        return service.getUser(uid);
    }

    @Path("/{uid}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String editUser(@PathParam("uid") long uid, User user) {
        user.setId(uid);
        return service.editUser(user);
    }

    @GET
    public List<User> getUsers() {
        return service.getUsers();
    }

//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void addUser(User user) {
//        service.addUser(user);
//    }
}
