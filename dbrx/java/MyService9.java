import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface CheckOwnership {
    String entity();
    String property();
}

interface UserRepository {
    // define methods for UserRepository
}

class Order {
    // define properties and methods for Order
}

@Service
public class MyService {

    @Autowired
    private UserRepository userRepository;

    @CheckOwnership(entity = "order", property = "payer")
    public void editOrder(Order order) {
        // ...
    }

}