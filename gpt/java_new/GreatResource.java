import org.springframework.security.access.annotation.Secured;

public final class AuthoritiesConstants {   
    public static final String SUPERVISED = "ROLE_SUPERVISED";
    // ...
}

@Secured({AuthoritiesConstants.SUPERVISED})
public class GreatResource {
    // ...
}