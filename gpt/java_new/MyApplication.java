import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

@ApplicationPath("/api")
public class MyApplication extends ResourceConfig {
    public MyApplication() {
        register(RolesAllowedDynamicFeature.class);
        // ... other registrations ...
    }
}