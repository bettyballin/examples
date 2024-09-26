import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SomeClass {

    private final UserService userService;

    @Autowired
    public SomeClass(UserService userService) {
        this.userService = userService;
    }
    
    // Other methods that use userService
}