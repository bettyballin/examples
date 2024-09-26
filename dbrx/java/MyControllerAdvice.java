import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(MyCustomExceptionThrownFromFindByUsername.class)
    public Mono<Void> handleMyCustomException(MyCustomExceptionThrownFromFindByUsername ex, ServerWebExchange exchange) {
        // Handle the custom exception here.
        return Mono.empty();
    }
}

class MyCustomExceptionThrownFromFindByUsername extends RuntimeException {
    public MyCustomExceptionThrownFromFindByUsername(String message) {
        super(message);
    }
}