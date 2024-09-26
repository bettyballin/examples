import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

public class WorkService {

    @Secured({"ROLE_OPERATOR", "ROLE_USER"})
    public void doWorkWithSecured() {
        // do useful processing
    }

    @PreAuthorize("hasRole('OPERATOR') or hasRole('USER')")
    public void doWorkWithPreAuthorize() {
        // do useful processing
    }
}