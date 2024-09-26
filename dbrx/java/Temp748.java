import java.io.Serializable;
import java.util.Collection;

public class Temp748 {
    public static void main(String[] args) {
        // This is just to make the code executable
        System.out.println("Interface UserDetails defined successfully.");
    }

    public interface GrantedAuthority extends Serializable {
        String getAuthority();
    }

    public interface UserDetails extends Serializable {
        String getPassword();
        Collection<? extends GrantedAuthority> getAuthorities();
    }
}