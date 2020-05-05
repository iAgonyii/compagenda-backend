package rest;

import domain.Team;
import service.TeamService;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("team")
public class TeamRest {

    private TeamService service = new TeamService();

    public TeamRest() { }

    @TokenNeeded
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createTeam(@FormParam("name") String name, @FormParam("user") long userId) {
        return Response.status(201).build();
    }
}
