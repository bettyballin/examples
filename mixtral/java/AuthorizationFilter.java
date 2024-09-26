import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.lang.reflect.Method;
import org.glassfish.jersey.server.model.ResourceMethodInvoker;

@Provider
public class AuthorizationFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext context) throws IOException {
        UriInfo uriInfo = context.getUriInfo();

        // Get the resource and method
        ResourceMethodInvoker invoker = (ResourceMethodInvoker)context.getProperty("org.glassfish.jersey.server.model.ResourceMethodInvoker");

        if (invoker != null) {
            Class<?> resourceClass = invoker.getResource().getClass();

            Method resourceMethod = invoker.getResourceMethod();

            // Now you can check your custom annotations on the class and method
        }
    }
}