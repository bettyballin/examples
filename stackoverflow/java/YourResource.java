import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

// Assuming Authentication is a valid class you have in your project
import your.package.Authentication;

@Path("/your-path")
public class YourResource {

    @GET
    @Path("/{id}")
    @Produces("text/plain")
    public String demonstration(@PathParam("id") String id,
                                @Context UriInfo ui, @Context Authentication auth) {
        // ... your code logic here ...
        return "Success";
    }
}