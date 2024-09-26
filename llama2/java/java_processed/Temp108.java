import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Configuration
public class Temp108 {

    @Autowired
    private UserDetailsService userDetailsService;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Temp108.class);
        Temp108 temp = context.getBean(Temp108.class);
        TokenBasedRememberMeServices services = temp.rememberMeServices();
        System.out.println("Token valid for seconds: " + services.getTokenValiditySeconds());
    }

    @Bean
    public TokenBasedRememberMeServices rememberMeServices() {
        TokenBasedRememberMeServices rememberMeServices = new TokenBasedRememberMeServices("yourKey", userDetailsService);
        rememberMeServices.setTokenValiditySeconds(1209600); // 2 weeks
        return rememberMeServices;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new org.springframework.security.core.userdetails.UserDetailsService() {
            @Override
            public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws org.springframework.security.core.userdetails.UsernameNotFoundException {
                return null; // implement your own UserDetailsService
            }
        };
    }
}