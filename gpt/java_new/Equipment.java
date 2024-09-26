import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

@Component
@Path("/equipment")
public class Equipment {

    @PreAuthorize("hasAnyRole('ROLE_ANALYST', 'ROLE_DEVELOPER')")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Object list(@Context UriInfo ui) {
        System.out.println(ui);
        return new java.util.HashMap<>();
    }
}