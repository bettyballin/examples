import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

// Assuming CompanyService and CompanyDaoAuthenticationProvider are part of your codebase
import your.package.CompanyService;
import your.package.CompanyDaoAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class MultiAuthConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private CompanyService companyService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(userAuthenticationProvider()).authenticationProvider(companyAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider userAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

    @Bean
    public CompanyDaoAuthenticationProvider companyAuthenticationProvider() {
        CompanyDaoAuthenticationProvider provider = new CompanyDaoAuthenticationProvider();
        provider.setCompanyService(companyService);
        return provider;
    }
}


Note: `CompanyDaoAuthenticationProvider` should extend `DaoAuthenticationProvider` or implement `AuthenticationProvider`. If it's a custom implementation, make sure it implements the necessary methods.