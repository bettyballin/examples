import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;

@Configuration
public class Temp560 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Temp560.class);
        DefaultSpringSecurityContextSource source = context.getBean(DefaultSpringSecurityContextSource.class);
        System.out.println("LDAP Server URL: " + source.getUrls()[0]);
    }

    @Bean
    public DefaultSpringSecurityContextSource ldapServer() {
        String url = "ldap://" + System.getProperty("security.ad.url", "defaultUrl");
        return new DefaultSpringSecurityContextSource(url);
    }
}