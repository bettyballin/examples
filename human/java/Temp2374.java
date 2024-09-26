import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Temp2374 {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    public static void main(String[] args) {
        Temp2374 temp = new Temp2374();
        // Assuming you want to perform some operations with userDetailsService here.
        // For example:
        // temp.userDetailsService.someMethod();
    }
}

// Assuming this is a sample implementation of UserDetailsServiceImpl
class UserDetailsServiceImpl {
    // Your methods and logic here
}