import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/resource")
public class Temp2180 {
    public static void main(String[] args) {
        // Main method logic if necessary
    }

    @RolesAllowed({"ROLE1", "ROLE"})
    @GET
    public Response getResource() throws Exception {
        return Response.ok("Resource accessed").build();
    }
}