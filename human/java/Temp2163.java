import org.springframework.ldap.core.support.InetOrgPersonContextMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Temp2163 {
    public static void main(String[] args) {
        Temp2163 temp = new Temp2163();
        InetOrgPersonContextMapper mapper = temp.userContextMapper();
        System.out.println("InetOrgPersonContextMapper Bean has been created: " + mapper);
    }

    @Bean
    public InetOrgPersonContextMapper userContextMapper() {
        return new InetOrgPersonContextMapper();
    }
}