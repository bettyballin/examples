import reactor.core.publisher.Mono;
import reactor.util.context.Context;
import reactor.util.context.ContextView;

public class Temp2370 {
    public static void main(String[] args) {
        // Dummy Mono for demonstration purposes
        Mono<String> updatedUser = Mono.just("user");

        // Executing the Mono with the context
        ReactiveSecurityContextHolder.withMono(updatedUser)
                .contextWrite(Context.of("key", "value"))
                .subscribe(System.out::println); // This will print 'user' if successful
    }
}

class ReactiveSecurityContextHolder {
    public static <T> Mono<T> withMono(Mono<T> mono) {
        return mono.contextWrite(Context.of("security", "context"));
    }
}