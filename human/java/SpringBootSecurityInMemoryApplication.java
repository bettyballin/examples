import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class SpringBootSecurityInMemoryApplication extends WebSecurityConfigurerAdapter implements CommandLineRunner {

    @Autowired
    private AuthenticationManager authenticationManager;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityInMemoryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        printUsersMap(authenticationManager);
    }

    public void printUsersMap(Object bean) {
        Field field = ReflectionUtils.findField(org.springframework.security.authentication.ProviderManager.class, "providers");
        ReflectionUtils.makeAccessible(field);
        List listOfProviders = (List) ReflectionUtils.getField(field, bean);
        DaoAuthenticationProvider dao = (DaoAuthenticationProvider) listOfProviders.get(0);
        Field fieldUserDetailService = ReflectionUtils.findField(DaoAuthenticationProvider.class, "userDetailsService");
        ReflectionUtils.makeAccessible(fieldUserDetailService);
        InMemoryUserDetailsManager userDet = (InMemoryUserDetailsManager) (ReflectionUtils.getField(fieldUserDetailService, dao));
        Field usersMapField = ReflectionUtils.findField(InMemoryUserDetailsManager.class, "users");
        ReflectionUtils.makeAccessible(usersMapField);
        Map map = (Map) ReflectionUtils.getField(usersMapField, userDet);
        System.out.println(map);
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build());
        manager.createUser(User.withDefaultPasswordEncoder().username("admin").password("password").roles("ADMIN").build());
        return manager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }
}