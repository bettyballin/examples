import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;

// Dummy classes to make the code compile
class UserPrincipal {
    public String getId() {
        return "dummyId";
    }
}

class Result {
}

class ResultRepository {
    public Result findByUserId(String userId) {
        return new Result();
    }
}

public class Temp1544 {
    private ResultRepository resultRepository = new ResultRepository(); // Added initialization

    public static void main(String[] args) {
        Temp1544 temp = new Temp1544();
        try {
            Result result = temp.getResult();
            System.out.println(result);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Cacheable(value = "resultCache", key = "#root.methodName")
    public Result getResult() {
        SecurityContextHolder.setContext(new SecurityContext());
        SecurityContextHolder.getContext().setAuthentication(new DummyAuthentication(true, new UserPrincipal()));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new IllegalStateException("User is not authenticated");
        }
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        return resultRepository.findByUserId(userPrincipal.getId());
    }
}

// Dummy SecurityContextHolder to make the code compile
class SecurityContextHolder {
    private static final ThreadLocal<SecurityContext> contextHolder = new ThreadLocal<>();

    public static SecurityContext getContext() {
        return contextHolder.get();
    }

    public static void setContext(SecurityContext context) {
        contextHolder.set(context);
    }
}

// Dummy SecurityContext to make the code compile
class SecurityContext {
    private Authentication authentication;

    public Authentication getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Authentication authentication) {
        this.authentication = authentication;
    }
}

// Dummy Authentication to make the code compile
class DummyAuthentication implements Authentication {
    private boolean authenticated;
    private UserPrincipal principal;

    public DummyAuthentication(boolean authenticated, UserPrincipal principal) {
        this.authenticated = authenticated;
        this.principal = principal;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Collection<?> getAuthorities() {
        return null;
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
        return principal;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.authenticated = isAuthenticated;
    }
}