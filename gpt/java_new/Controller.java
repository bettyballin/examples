import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.AccessDeniedException;

@RestController
@RequestMapping("/api")
public class Controller {

    @PreAuthorize("hasRole('ROLE_A') or hasRole('ROLE_B')")
    @RequestMapping(value = "{uid}", method = RequestMethod.GET)
    public Response getSomething(@PathVariable("uid") String uid, Authentication authentication) {
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_A"))) {
            return getSomethingForRoleA(uid);
        } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_B"))) {
            return getSomethingForRoleB(uid);
        } else {
            throw new AccessDeniedException("Not authorized to access this resource");
        }
    }
    
    private Response getSomethingForRoleA(String uid) {
        // Implementation specific code
        return new Response(); // placeholder response
    }

    private Response getSomethingForRoleB(String uid) {
        // Implementation specific code
        return new Response(); // placeholder response
    }
    
    // Placeholder Response class
    private static class Response {
        // fields, constructors, getters and setters
    }
}