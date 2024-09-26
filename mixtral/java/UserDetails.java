import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

// Define GrantedAuthority interface
interface GrantedAuthority {}

// Define a subclass implementing GrantedAuthority
class GrantedAuthoritySubClass implements GrantedAuthority {}

public class UserDetails {

    Collection<? extends GrantedAuthority> authorities;

    public void setAuthorities(Collection<? extends GrantedAuthority> auth){
        this.authorities = new ArrayList<>(auth);
    }
}

// In your main method:
public class Main {

    public static void main(String[] args) {

        UserDetails u = new UserDetails();

        List<GrantedAuthoritySubClass> list = Arrays.asList(new GrantedAuthoritySubClass());

        // Now you can add the subclass objects to your collection
        u.setAuthorities(list);
    }
}