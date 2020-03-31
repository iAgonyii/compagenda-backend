package rest;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.annotation.Priority;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@TokenNeeded
@Provider
@Priority(Priorities.AUTHENTICATION)
public class TokenNeededFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext containerRequestContext) {
        String auth = containerRequestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        if (auth == null || !auth.startsWith("Bearer ")) {
            throw new NotAuthorizedException("No Bearer");
        }

        String token = auth.substring("Bearer ".length()).trim();
        Jwts.parser().setSigningKey(Keys.secretKeyFor(SignatureAlgorithm.HS256)).parseClaimsJws(token);
    }
}
