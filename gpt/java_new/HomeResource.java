import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
public class HomeResource {
    
    @GET
    public Response home() {
        return Response.ok("Hello World").build();
    }
}