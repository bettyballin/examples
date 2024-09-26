import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Arrays;

public class Temp1034 {

    public static void main(String[] args) {
        Temp1034 temp = new Temp1034();
        SecurityContextHolder.setContext(new SecurityContext());
        temp.doSomethingSecure();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') and hasRole('ROLE_EMPLOYEE')")
    public void doSomethingSecure() {
        System.out.println("Secure method accessed.");
    }

    static class SecurityContext implements org.springframework.security.core.context.SecurityContext {
        private org.springframework.security.core.Authentication authentication;

        public SecurityContext() {
            InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager(Arrays.asList(
                    new User("user", "password", Arrays.asList(() -> "ROLE_ADMIN", () -> "ROLE_EMPLOYEE"))
            ));
            authentication = new org.springframework.security.authentication.UsernamePasswordAuthenticationToken(
                    manager.loadUserByUsername("user"), null, manager.loadUserByUsername("user").getAuthorities());
        }

        @Override
        public org.springframework.security.core.Authentication getAuthentication() {
            return authentication;
        }

        @Override
        public void setAuthentication(org.springframework.security.core.Authentication authentication) {
            this.authentication = authentication;
        }
    }
}