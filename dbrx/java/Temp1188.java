import org.mockito.Mockito;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class Main {
    public static void main(String[] args) {
        HttpSecurity httpSecurity = Mockito.mock(HttpSecurity.class, Mockito.RETURNS_DEEP_STUBS);
        // Additional code to use the mocked httpSecurity can be added here
    }
}