import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.acls.jdbc.JdbcMutableAclService;
import org.springframework.security.acls.jdbc.LookupStrategy;
import org.springframework.security.acls.jdbc.BasicLookupStrategy;
import org.springframework.security.acls.model.MutableAclService;
import org.springframework.security.acls.domain.AclAuthorizationStrategyImpl;
import org.springframework.security.acls.domain.ConsoleAuditLogger;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.sql.DataSource;

@Configuration
public class AppConfig extends WebSecurityConfigurerAdapter implements ApplicationContextAware {

    @Autowired
    private DataSource dataSource;

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public MutableAclService aclService() throws Exception {
        LookupStrategy lookupStrategy = new BasicLookupStrategy(
                dataSource,
                new AclAuthorizationStrategyImpl(new SimpleGrantedAuthority("ROLE_ADMIN")),
                new ConsoleAuditLogger()
        );

        return new JdbcMutableAclService(dataSource, lookupStrategy, new ConsoleAuditLogger());
    }
}