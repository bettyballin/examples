import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import reactor.core.publisher.Mono;

import java.security.Principal;

public class SecurityService1 {

    public Mono<String> test() {
        return ReactiveSecurityContextHolder.getContext()
                .map(ctx -> validate(ctx.getAuthentication()));
    }

    private String validate(Authentication authentication) {
        String name = ((Principal) authentication.getPrincipal()).getName();
        return name;
    }
}