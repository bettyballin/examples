import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import static org.mockito.Mockito.*;

public class Temp2703 {
    public static void main(String[] args) {
        HttpSecurity mockHttpSecurity = mock(HttpSecurity.class, withSettings().defaultAnswer(RETURNS_DEEP_STUBS));
        CsrfConfigurer<HttpSecurity> csrf = mockHttpSecurity.csrf();
        when(csrf.disable()).thenReturn(mockHttpSecurity);
        
        HttpSecurity disable = csrf.disable();
        try {
            disable.headers();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}