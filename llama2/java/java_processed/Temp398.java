import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Repository;

public class Temp398 {
    public static void main(String[] args) {
        // Sample main code
        System.out.println("Main method executed.");
    }
}

@Repository
interface MyRepository {
    @GetMapping("/users")
    List<MyUser> getUsers(@CurrentUser MyUser user);
}

// Assuming a class MyUser and an annotation @CurrentUser
class MyUser {
    private String name;

    public MyUser(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@interface CurrentUser {
}