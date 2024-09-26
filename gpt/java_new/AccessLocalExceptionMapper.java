import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Provider
public class AccessLocalExceptionMapper implements ExceptionMapper<AccessLocalException> {

    @Override
    @Produces(MediaType.TEXT_PLAIN)
    public Response toResponse(AccessLocalException exception) {
        return Response.status(Response.Status.UNAUTHORIZED)
                       .entity("Client not authorized")
                       .type(MediaType.TEXT_PLAIN)
                       .build();
    }
}

class AccessLocalException extends Exception {
    private static final long serialVersionUID = 1L;

    public AccessLocalException(String message) {
        super(message);
    }
}