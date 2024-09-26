import javax.annotation.Priority;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.RuntimeDelegate;
import javax.ws.rs.container.ResourceInfo;
import java.io.IOException;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class SecurityFilter implements ContainerRequestFilter {

    @Context
    private ResourceInfo resourceInfo;

    @Override
    public void filter(ContainerRequestContext context) throws IOException {
        // here we have access to headers:
        String authorizationHeader = context.getHeaderString("Authorization");

        // and, thanks to injected resourceInfo, to annotations:
        RolesAllowed annotation = resourceInfo
                .getResourceClass() // or getResourceMethod(), I've used both
                    .getAnnotation(RolesAllowed.class);
        // and, finally, to the roles (after a null-check)
        String[] roles = new String[0];
        if (annotation != null) {
            roles = annotation.value();
        }

        // Authentication and authorization logic
        boolean isAuthenticated = authenticate(authorizationHeader);
        boolean isAuthorized = authorize(roles);

        // then you can authenticate and authorize everything on your own using any method (I’ve used Basic Auth and JWT)
        // and, if something fails, you can abort the request:
        if (!isAuthenticated) {
            context.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        } else if (!isAuthorized) {
            context.abortWith(Response.status(Response.Status.FORBIDDEN).build());
        }
    }

    private boolean authenticate(String authorizationHeader) {
        // Implement your authentication logic here
        // For example, validate the authorizationHeader token
        return authorizationHeader != null && authorizationHeader.startsWith("Bearer ");
    }

    private boolean authorize(String[] roles) {
        // Implement your authorization logic here
        // For example, check if the user has one of the required roles
        return roles.length == 0 || roles[0].equals("USER"); // Simplified example
    }
}