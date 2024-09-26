import org.springframework.security.access.annotation.Secured;

public class WorkService {

    @Secured({"ROLE_OPERATOR", "ROLE_USER"})
    public void doWork() {
        // ... method implementation ...
    }
}