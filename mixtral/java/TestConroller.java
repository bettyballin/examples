import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class TestController {

    public void test() {
        ReactiveSecurityContextHolder.getContext()
            .map(SecurityContext::getAuthentication)
            .doOnNext(this::validate)
            .subscribe();
    }

    private void validate(Authentication auth) {
        System.out.println(auth.getName());
    }

    public static void main(String[] args) {
        // Simulate setting a security context for testing
        Authentication auth = new MockAuthentication("testUser");
        SecurityContext context = new MockSecurityContext(auth);
        Mono<SecurityContext> contextMono = Mono.just(context);
        ReactiveSecurityContextHolder.withSecurityContext(contextMono).subscribe();

        // Create an instance of the controller and call the test method
        TestController controller = new TestController();
        controller.test();
    }
}

class MockAuthentication implements Authentication {
    private final String name;

    public MockAuthentication(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    // Implement the rest of the Authentication methods as needed
    @Override public Collection<? extends GrantedAuthority> getAuthorities() { return null; }
    @Override public Object getCredentials() { return null; }
    @Override public Object getDetails() { return null; }
    @Override public Object getPrincipal() { return null; }
    @Override public boolean isAuthenticated() { return true; }
    @Override public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException { }
}

class MockSecurityContext implements SecurityContext {
    private final Authentication authentication;

    public MockSecurityContext(Authentication authentication) {
        this.authentication = authentication;
    }

    @Override
    public Authentication getAuthentication() {
        return authentication;
    }

    @Override
    public void setAuthentication(Authentication authentication) {
    }
}