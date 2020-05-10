package rest;

import domain.Team;
import service.TeamService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("team")
public class TeamRest {

    @Inject
    private TeamService service;

    public TeamRest() { }

    @TokenNeeded
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createTeam(@FormParam("name") String name, @FormParam("user") long userId) {
        if(service.createTeam(name, userId)) {
            return Response.status(201).build();
        }
        else {
            return Response.status(409).build();
        }
    }
}
