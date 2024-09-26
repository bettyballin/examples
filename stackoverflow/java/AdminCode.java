import org.springframework.security.access.annotation.Secured;

public class AdminCode {

    @Secured("ROLE_ADMIN")
    public void doAdminStuff() {
        // do stuff
    }

}