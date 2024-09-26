import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreInvocationAuthorizationAdviceVoter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;

import java.util.Arrays;

public class Temp1164 {
    public static void main(String[] args) {
        SecurityContextHolder.setContext(new SecurityContextImpl(new TestingAuthenticationToken("user", "password", Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")))));

        SecureResource secureResource = new SecureResourceImpl();
        secureResource.secureMethod();
    }

    public interface SecureResource {
        @PreAuthorize("hasRole('ROLE_ADMIN')")
        void secureMethod();
    }

    public static class SecureResourceImpl implements SecureResource {
        @Override
        public void secureMethod() {
            System.out.println("Executing secure method.");
        }
    }
}