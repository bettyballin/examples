import com.fasterxml.jackson.databind.ObjectMapper;
import javax.ws.rs.BeanParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/sync")
public class MyEndpoint {

    @POST
    public Response sync(String json) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        MyClassRequest myClassRequest = objectMapper.readValue(json, MyClassRequest.class);
        // ...
        return Response.ok().build();
    }

    public static class MyClassRequest {
        // Define fields and methods for MyClassRequest
    }
}


Note: The `@BeanParam` annotation is not needed in this case, as it's used for injecting parameters from the HTTP request into a JavaBean object. Since `json` is a simple `String` parameter, the annotation can be removed.