import org.springframework.context.annotation.Bean;
import org.springframework.ldap.core.support.InetOrgPersonContextMapper;

public class SomeConfigurationClass {

    @Bean
    public InetOrgPersonContextMapper userContextMapper() {
        return new InetOrgPersonContextMapper();
    }
}