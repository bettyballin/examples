import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.servlet.http.HttpSession;

public class Temp399 {
    public static void main(String[] args) {
        HttpSession session = new MockHttpSession(); // Mock session for demonstration
        CustomUserDetails customUserDetails = (CustomUserDetails) session.getAttribute("user");

        if (customUserDetails != null && customUserDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            // User has admin role
            System.out.println("User has admin role");
        } else {
            System.out.println("User does not have admin role");
        }
    }
}

class MockHttpSession implements HttpSession {
    // Mock implementation of HttpSession

    @Override
    public Object getAttribute(String name) {
        if ("user".equals(name)) {
            return new CustomUserDetails(); // Return a mock CustomUserDetails object
        }
        return null;
    }

    // Implement other methods as needed

    @Override
    public Object getValue(String name) { return null; }
    @Override
    public Enumeration<String> getAttributeNames() { return null; }
    @Override public long getCreationTime() { return 0; }
    @Override public String getId() { return null; }
    @Override public long getLastAccessedTime() { return 0; }
    @Override public ServletContext getServletContext() { return null; }
    @Override public void setMaxInactiveInterval(int interval) { }
    @Override public int getMaxInactiveInterval() { return 0; }
    @Override public HttpSessionContext getSessionContext() { return null; }
    @Override public Object getValueNames() { return null; }
    @Override public void putValue(String name, Object value) { }
    @Override public void removeValue(String name) { }
    @Override public void invalidate() { }
    @Override public boolean isNew() { return false; }
    @Override public void removeAttribute(String name) { }
    @Override public void setAttribute(String name, Object value) { }
}

class CustomUserDetails implements UserDetails {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    @Override public String getPassword() { return null; }
    @Override public String getUsername() { return null; }
    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }
}