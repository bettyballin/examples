import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.springframework.security.access.prepost.PreAuthorize;

public class Temp934 {
    public static void main(String[] args) {
        // Placeholder for main method logic
    }

    @PreAuthorize("hasAnyRole('ROLE_ANALYST', 'ROLE_DEVELOPER')")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String list(@Context UriInfo ui) {
        // Placeholder for method logic
        return "{}";
    }
}