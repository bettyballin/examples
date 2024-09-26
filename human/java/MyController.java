import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}

@RestController
class MyController {
    @GetMapping("/test")
    public void getWithTransformedPrincipal(@AuthenticationPrincipal Principal principal) {
        GenericPrincipal generic = PrincipalTransformer.transform(principal);
        doSomethingWithPrincipal(generic);
    }

    private void doSomethingWithPrincipal(GenericPrincipal principal) {
        // Your logic here
    }
}

class PrincipalTransformer {
    public static GenericPrincipal transform(Principal principal) {
        // Transform the principal to GenericPrincipal
        return new GenericPrincipal(principal.getName());
    }
}

class GenericPrincipal {
    private String name;

    public GenericPrincipal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}