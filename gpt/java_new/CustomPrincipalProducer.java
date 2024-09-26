import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import java.security.Principal;

@RequestScoped
public class CustomPrincipalProducer {

    @Inject
    private javax.ws.rs.core.SecurityContext securityContext;

    @Produces
    public Principal currentPrincipal() {
        return securityContext.getUserPrincipal();
    }
}