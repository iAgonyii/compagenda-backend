package rest;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import io.jsonwebtoken.security.Keys;


import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED;

@Stateless
@Path("auth")
public class AuthRest {

    @POST
    @Path("/login")
    @Consumes(APPLICATION_FORM_URLENCODED)
    public Response auth(@FormParam("login") String login, @FormParam("password") String password) {

        // Authenticate

        return Response.ok().header(AUTHORIZATION, "BEARER " + issueToken(login)).build();
    }

    public String issueToken(String login) {
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        return Jwts.builder().signWith(key).setSubject(login).compact();
    }
}
