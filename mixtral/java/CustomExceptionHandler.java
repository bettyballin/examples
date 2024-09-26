import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;

@Provider
public class CustomExceptionHandler implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {
        if (exception instanceof AuthenticationCredentialsNotFoundException) {
            return Response
                .status(Status.UNAUTHORIZED)
                .header("Location", "http://your-login-page")
                .build();
        }

        // Handle other exceptions as needed
        return Response.status(Status.INTERNAL_SERVER_ERROR).entity(exception.getMessage()).build();
    }
}