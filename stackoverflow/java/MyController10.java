import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;

@RestController
public class MyController10 {

    @GetMapping("/test")
    public void getWithTransformedPrincipal(@AuthenticationPrincipal Principal principal) {
        // Assuming PrincipalTransformer is a valid class and doSomethingWithPrincipal is a valid method
        PrincipalTransformer transformer = new PrincipalTransformer();
        GenericPrincipal generic = transformer.transform(principal);
        doSomethingWithPrincipal(generic);
    }

    // Assuming GenericPrincipal is a valid class
    private void doSomethingWithPrincipal(GenericPrincipal generic) {
        // perform operations with generic principal
    }

    // Assuming this is a placeholder for an actual transformer class
    private class PrincipalTransformer {
        public GenericPrincipal transform(Principal principal) {
            // transform principal into GenericPrincipal
            return new GenericPrincipal(); // Assuming GenericPrincipal has a no-argument constructor
        }
    }

    // Assuming this is a placeholder for an actual GenericPrincipal class
    private class GenericPrincipal {
        // GenericPrincipal implementation
    }
}