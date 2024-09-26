import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// Assuming MyPrincipalProducer and MyPrincipal classes exist and are properly implemented
class MyPrincipalProducer {
    public MyPrincipal getCurrentUser() {
        return new MyPrincipal("defaultUser"); // Example implementation
    }
}

class MyPrincipal {
    private String name;

    public MyPrincipal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

@Path("/myresource")
public class MyResource {

    @Inject
    private MyPrincipalProducer myPrincipalProducer;

    @GET
    @Path("/username")
    @Produces(MediaType.TEXT_PLAIN)
    public String getUsername() {
        return myPrincipalProducer.getCurrentUser().getName();
    }

    public static void main(String[] args) {
        MyPrincipalProducer producer = new MyPrincipalProducer();
        MyResource resource = new MyResource();
        resource.myPrincipalProducer = producer; // Simulating dependency injection
        System.out.println(resource.getUsername());
    }
}