import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreInvocationAuthorizationAdviceVoter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.access.AccessDeniedException;

import java.util.Arrays;

public class Temp1309 {
    public static void main(String[] args) {
        Temp1309 temp = new Temp1309();
        SecurityContextHolder.setContext(new SecurityContext() {
            @Override
            public Authentication getAuthentication() {
                return new Authentication() {
                    @Override
                    public Collection<? extends GrantedAuthority> getAuthorities() {
                        return Arrays.asList(() -> "GOOD_ROLE1");
                    }

                    @Override
                    public Object getCredentials() {
                        return null;
                    }

                    @Override
                    public Object getDetails() {
                        return null;
                    }

                    @Override
                    public Object getPrincipal() {
                        return null;
                    }

                    @Override
                    public boolean isAuthenticated() {
                        return true;
                    }

                    @Override
                    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

                    }

                    @Override
                    public String getName() {
                        return null;
                    }
                };
            }

            @Override
            public void setAuthentication(Authentication authentication) {

            }
        });
        try {
            temp.methodAccessibleByAnyoneButThirdPartyRole();
        } catch (AccessDeniedException e) {
            System.out.println("Access denied.");
        }
    }

    @PreAuthorize("hasRole('GOOD_ROLE1') or hasRole('GOOD_ROLE2') or hasRole('GOOD_ROLE3')")
    public void methodAccessibleByAnyoneButThirdPartyRole() {
        System.out.println("Method executed.");
    }
}