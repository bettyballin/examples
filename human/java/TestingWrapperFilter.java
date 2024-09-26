import java.io.IOException;
import java.security.Principal;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;

public class TestingWrapperFilter implements Filter {
    private Object credentials = "password";
    private String rolePrefix = "ROLE";

    @Override
    public void init(FilterConfig fc) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) sr;
        Principal principal = req.getUserPrincipal();
        if (principal != null) {
            Authentication auth;
            auth = (principal instanceof Authentication) ? (Authentication) principal :
                    new TestingAuthenticationToken(principal, credentials);
            SecurityContext sc = new SecurityContextImpl();
            sc.setAuthentication(auth);
            SecurityContextHolder.setContext(sc);
        }
        else {
            SecurityContextHolder.clearContext();
        }
        sr = new SecurityContextHolderAwareRequestWrapper(req, rolePrefix);
        fc.doFilter(sr, sr1);
    }

    @Override
    public void destroy() {
    }

    public void setCredentials(Object credentials) {
        this.credentials = credentials;
    }

    public void setRolePrefix(String rolePrefix) {
        this.rolePrefix = rolePrefix;
    }
}

class TestingAuthenticationToken implements Authentication {
    private final Principal principal;
    private final Object credentials;

    public TestingAuthenticationToken(Principal principal, Object credentials) {
        this.principal = principal;
        this.credentials = credentials;
    }

    @Override
    public String getName() {
        return principal.getName();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public Object getCredentials() {
        return credentials;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
    }
}