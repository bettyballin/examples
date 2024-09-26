import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import reactor.core.publisher.Mono;

import java.security.Principal;

public class Temp3660 {
    public static void main(String[] args) {
        Temp3660 temp = new Temp3660();
        temp.test().subscribe(System.out::println);
    }

    public Mono<String> test() {
        return ReactiveSecurityContextHolder.getContext()
                .map(ctx -> validate(ctx.getAuthentication()));
    }

    private String validate(Authentication authentication) {
        String name = ((Principal) authentication.getPrincipal()).getName();

        // validate
        return name;
    }
}


Note: To run this code successfully, you need a proper Spring Security and Reactor setup in your project. This standalone example assumes you have the necessary dependencies and context setup.