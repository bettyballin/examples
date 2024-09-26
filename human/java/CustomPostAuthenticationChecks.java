import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;

import java.util.Collection;

public class CustomPostAuthenticationChecks implements UserDetailsChecker {

    @Override
    public void check(UserDetails userDetails) {

        CustomUser customUser = (CustomUser) userDetails;
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();

        // Clear existing authorities
        authorities.clear();

        if (customUser.needsEmailAuthentication()) {
            // Set the new authority, only allowing access to the email authentication page.
            authorities.add(new SimpleGrantedAuthority("ROLE_NEEDS_EMAIL_AUTH"));
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_AUTHORIZED_USER"));
        }
    }

    public static class CustomUser implements UserDetails {

        private boolean emailAuthenticationNeeded;
        private Collection<SimpleGrantedAuthority> authorities;

        public CustomUser(boolean emailAuthenticationNeeded) {
            this.emailAuthenticationNeeded = emailAuthenticationNeeded;
            this.authorities = new java.util.ArrayList<>();
        }

        public boolean needsEmailAuthentication() {
            return emailAuthenticationNeeded;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return authorities;
        }

        @Override
        public String getPassword() {
            return null;
        }

        @Override
        public String getUsername() {
            return null;
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }

    public static void main(String[] args) {
        CustomUser user = new CustomUser(true);
        CustomPostAuthenticationChecks checker = new CustomPostAuthenticationChecks();
        checker.check(user);
        for (GrantedAuthority authority : user.getAuthorities()) {
            System.out.println(authority.getAuthority());
        }
    }
}