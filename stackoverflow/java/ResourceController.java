import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.core.Response;

public class ResourceController {

    @RolesAllowed({"ROLE1", "ROLE"})
    @GET
    public Response getResource() throws Exception {
        // Implementation here
        return Response.ok().build();
    }
}