import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.annotation.security.RolesAllowed;

@Path("/myresource")
public class MyResource {

    @GET
    @Produces("application/json")
    @RolesAllowed({"AUTHENTICATED_USER", "ADMIN"})
    public Response getData() {
        String json = "{\"message\": \"Hello, World!\"}";
        return Response.ok(json).build();
    }
}