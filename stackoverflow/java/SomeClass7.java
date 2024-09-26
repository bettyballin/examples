import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SomeClass7 {
    public Object getDesiredDataFromPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetailsImplementation) {
            return ((UserDetailsImplementation) authentication.getPrincipal()).getDesiredData();
        }
        return null; // or throw an exception depending on your requirements
    }
  
    private static class UserDetailsImplementation {
        // Assuming this method exists within UserDetailsImplementation class
        public Object getDesiredData() {
            // implementation details
            return new Object(); // replace with actual return data
        }
    }
}