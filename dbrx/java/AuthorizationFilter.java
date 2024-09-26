import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.container.ResourceInfo;
import java.io.IOException;
import java.lang.reflect.Method;

@Provider
public class AuthorizationFilter implements ContainerRequestFilter {

    @Context
    private ResourceInfo resourceInfo;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        // Get the requested URI and method.
        String uri = requestContext.getUriInfo().getRequestUri().toString();
        Method method = resourceInfo.getResourceMethod();

        // Perform your authorization logic here based on extracted info.
    }
}