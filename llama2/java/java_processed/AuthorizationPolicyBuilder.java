import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AuthorizationPolicyBuilder {
    private final List<AuthorizationRule> rules = new ArrayList<>();

    public AuthorizationPolicyBuilder hasOAuth2Scope(String scope) {
        rules.add(new AuthorizationRule(scope, true));
        return this;
    }

    public AuthorizationPolicyBuilder isNotOAuth2Request() {
        rules.add(new AuthorizationRule("!isOAuth2Request", false));
        return this;
    }

    public AuthorizationPolicyBuilder hasRole(String role) {
        rules.add(new AuthorizationRule(role, true));
        return this;
    }

    @Override
    public String toString() {
        return rules.stream().map(AuthorizationRule::toString).collect(Collectors.joining(" && "));
    }

    public static void main(String[] args) {
        AuthorizationPolicyBuilder builder = new AuthorizationPolicyBuilder();
        builder.hasOAuth2Scope("read")
               .isNotOAuth2Request()
               .hasRole("admin");
        System.out.println(builder);
    }
}

class AuthorizationRule {
    private final String expression;
    private final boolean positive;

    public AuthorizationRule(String expression, boolean positive) {
        this.expression = expression;
        this.positive = positive;
    }

    @Override
    public String toString() {
        return positive ? "(" + expression + ")" : "(!" + expression + ")";
    }
}