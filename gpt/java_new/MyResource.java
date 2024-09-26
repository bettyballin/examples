import java.security.Principal;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

@Path("/myresource")
public class MyResource {

    @Context
    private SecurityContext securityContext;

    @GET
    @Path("/method1")
    public String method1() {
        Principal userPrincipal = securityContext.getUserPrincipal();
        if (userPrincipal != null) {
            return "Hello, " + userPrincipal.getName();
        }
        return "Hello, guest";
    }
}