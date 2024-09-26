import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SomeController {

    @RequestMapping("/some-url")
    public String someMethod(@AuthenticationPrincipal User user) {
        // Access custom details
        System.out.println(user.getUsername());
        return "someView"; // Assuming you have a view named 'someView'
    }
}

@Service
class SomeServiceImpl implements SomeService {

    @Autowired
    private AuthenticationManager authenticationManager;

    // Implement methods from SomeService interface here
}

interface SomeService {
    // Define methods to be implemented by SomeServiceImpl
}