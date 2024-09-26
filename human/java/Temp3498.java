import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import reactor.core.publisher.Mono;

public class Temp3498 {
    public static void main(String[] args) {
        chainFilter();
    }

    public static Mono<Void> chainFilter() {
        return ReactiveSecurityContextHolder.getContext()
                .doOnNext(sc -> {
                    if (sc.getAuthentication() != null) {
                        // custom logic on sc.getAuthentication().getName()
                        System.out.println("Authenticated user: " + sc.getAuthentication().getName());
                    }
                })
                .then(Mono.empty()); // Placeholder for chain.filter(exchange)
    }
}