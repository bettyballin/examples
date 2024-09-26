import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.security.enterprise.identitystore.IdentityStore;
import java.util.Set;

@ApplicationScoped
public class CustomIdentityStore implements IdentityStore {

    @Inject
    private DatabaseService databaseService;

    public Set<String> getRolesByUser(String username, String... additionalAttributes) {
        // Custom query to get roles with additional attributes
        return databaseService.getRolesForUser(username, additionalAttributes);
    }

    @Override
    public int priority() {
        return 10;
    }
    
    // Assume DatabaseService interface is defined somewhere with the getRolesForUser method
    // The actual implementation of DatabaseService is not provided, but it's necessary for the code to compile.
}