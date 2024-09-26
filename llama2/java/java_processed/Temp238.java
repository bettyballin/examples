import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class Temp238 {
    public static void main(String[] args) {
        System.out.println("Temp238 is running");
    }

    public interface CustomUserDetailsService extends UserDetailsService {
        @Override
        UserDetails loadUserByUsername(String username);
    }
}
``` 
should be 
```java
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class Temp238 {
    public static void main(String[] args) {
        System.out.println("Temp238 is running");
    }
}

interface CustomUserDetailsService extends UserDetailsService {
    @Override
    UserDetails loadUserByUsername(String username);
}