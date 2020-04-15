package rest;

import domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.Console;
import java.security.Key;
import java.time.Instant;
import java.util.Date;
import javax.crypto.spec.SecretKeySpec;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.impl.TextCodec;
import io.jsonwebtoken.security.Keys;
import org.mindrot.jbcrypt.BCrypt;
import service.UserService;


import static javax.crypto.Cipher.SECRET_KEY;
import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED;

@Stateless
@Path("auth")
public class AuthRest {

    UserService service;

    @POST
    @Path("/login")
    @Consumes(APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response auth(@FormParam("username") String username, @FormParam("password") String password) {
        service = new UserService();
        if(service.login(username, password)) {
            long id = service.getIdForName(username);
            return Response.ok().header(AUTHORIZATION, "BEARER " + issueToken(id)).build();
        }
        else {
            return Response.ok().status(Response.Status.UNAUTHORIZED).build();
        }
    }

    @POST
    @Path("/register")
    @Consumes(APPLICATION_FORM_URLENCODED)
    public Response register(@FormParam("username") String username, @FormParam("email") String email, @FormParam("password") String password) {
        User user = new User(username, email, password);
        service = new UserService();
        if(service.register(user)) {
            return Response.status(201).build();
        }
        else {
            return Response.status(409).build();
        }
    }






    private String issueToken(long id) {
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("UGVwZWdhIENsYXAgV29ybGQgUmVjb3Jk");
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName());

        String jws = Jwts.builder()
                .setIssuer("CompAgenda")
                .setSubject(String.valueOf(id))
                .setIssuedAt(new Date())
                // Sat Jun 24 2116 15:33:42 GMT-0400 (EDT)
                .setExpiration(Date.from(Instant.ofEpochSecond(4622470422L)))

                .signWith(
                        SignatureAlgorithm.HS256,
                        signingKey
                )
                .compact();
        return jws;
    }
}
