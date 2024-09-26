import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.security.Principal;

@Path("/myresource")
public class MyResource {

    private final SecurityContext securityContext;

    public MyResource(@Context SecurityContext securityContext) {
        this.securityContext = securityContext;
    }

    @GET
    public Response get() {
       Principal principal = securityContext.getUserPrincipal();

      // ...

      return Response.ok().build();
    }
}