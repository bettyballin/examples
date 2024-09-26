import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class AsInternalUser implements AutoCloseable {

    private final SecurityContext previousContext;

    public AsInternalUser() {
        previousContext = SecurityContextHolder.getContext();
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(
                new AnonymousAuthenticationToken("INTERNAL","INTERNAL_USERNAME", AuthorityUtils.createAuthorityList("ROLE_INTERNAL"))
        );
        SecurityContextHolder.setContext(
                context
        );
    }

    @Override
    public void close() {
        if (previousContext == null) {
            SecurityContextHolder.clearContext();
        } else {
            SecurityContextHolder.setContext(previousContext);
        }
    }

    public static void main(String[] args) {
        try (AsInternalUser asInternalUser = new AsInternalUser()) {
            System.out.println("Running as internal user");
            // Add any additional logic here to be executed as internal user
        }
        System.out.println("Reverted back to previous user context");
    }
}