import org.springframework.stereotype.Service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Service
public class MyService {

    @Authorized(roles = {"ADMIN", "USER"})
    public void doSomething() {
        // ...
    }

}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Authorized {
    String[] roles();
}