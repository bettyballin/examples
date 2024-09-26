import org.springframework.security.access.prepost.PreAuthorize;

public class YourController2 {

    @PreAuthorize("hasRole('ADMIN')")
    public String yourControllerMethod() {
        String response = "some response";
        return response;
    }
}