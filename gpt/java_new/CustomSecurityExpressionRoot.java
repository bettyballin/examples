import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.core.Authentication;

import java.util.UUID;

public class CustomSecurityExpressionRoot extends SecurityExpressionRoot {

    private UUID homeOrg;

    public CustomSecurityExpressionRoot(Authentication authentication, UUID homeOrg) {
        super(authentication);
        this.homeOrg = homeOrg;
    }

    // Your custom methods that use homeOrg for decision-making
    // Example custom method
    public boolean isHomeOrg(UUID someOrg) {
        return homeOrg.equals(someOrg);
    }
}