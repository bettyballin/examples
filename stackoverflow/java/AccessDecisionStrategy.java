import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.core.Authentication;
import org.springframework.security.access.ConfigAttribute;

public interface AccessDecisionStrategy {

    void decide(Authentication authentication, MethodInvocation methodInvocation, ConfigAttribute configAttribute);

}