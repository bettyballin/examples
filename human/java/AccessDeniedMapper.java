import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

// Custom exception for access denied
class AccessDeniedException extends Exception {
    public AccessDeniedException(String message) {
        super(message);
    }
}

// Annotate the class with @Provider to register it with the Jersey framework
@Provider
public class AccessDeniedMapper implements ExceptionMapper<AccessDeniedException> {
    @Override
    public Response toResponse(AccessDeniedException e) {
        return Response.status(401).build();
    }
}

// Main class to demonstrate the usage
public class Main {
    public static void main(String[] args) {
        // Simulating the behavior
        AccessDeniedMapper mapper = new AccessDeniedMapper();
        AccessDeniedException exception = new AccessDeniedException("Access Denied");
        Response response = mapper.toResponse(exception);
        System.out.println("Response Status: " + response.getStatus());
    }
}