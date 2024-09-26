import org.apache.shiro.realm.AuthorizingRealm;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.scm.auth")
public class ApplicationRealm extends AuthorizingRealm {
    // Class body goes here
}