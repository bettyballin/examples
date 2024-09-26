import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;

public class Temp929 {
    public static void main(String[] args) {
        // Assuming getUtenteConnesso() is defined somewhere and returns an object with getAuthorities() method
        List<GrantedAuthority> authorities = new ArrayList<>(getUtenteConnesso().getAuthorities());
    }

    // Mock method for demonstration purposes
    private static UtenteConnesso getUtenteConnesso() {
        return new UtenteConnesso();
    }

    // Mock class for demonstration purposes
    private static class UtenteConnesso {
        public List<GrantedAuthority> getAuthorities() {
            // Mock implementation
            return new ArrayList<>();
        }
    }
}