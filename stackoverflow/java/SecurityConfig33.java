import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.example.ApiWebSecurityConfig33urationAdapter;
import com.example.FormLoginWebSecurityConfig33urerAdapter;

@Configuration
@Import({ApiWebSecurityConfig33urationAdapter.class, FormLoginWebSecurityConfig33urerAdapter.class})
public class SecurityConfig33 {
}