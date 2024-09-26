import javax.ws.rs.*;
import javax.ws.rs.core.*;

public class Temp866 {
    @GET
    @Path("/{id}")
    @Produces("text/plain")
    public String demonstration(@PathParam("id") String id,
                                @Context UriInfo ui, @Context SecurityContext auth) {
        // Placeholder implementation
        return "ID: " + id;
    }
    
    public static void main(String[] args) {
        // Typically, a JAX-RS application would be run in a servlet container or application server
        // This main method is just a placeholder and won't actually run the JAX-RS resource
        System.out.println("This is a JAX-RS resource class.");
    }
}