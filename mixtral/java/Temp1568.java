import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;
import java.util.Set;

@Configuration
@EnableWebSecurity
public class Temp1568 extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    // SQL queries
    String usersQuery = "select email, password, enabled from user where email=?";
    String rolesQuery = "select u.email, r.role from user u inner join user_role ur on (u.id=ur.user_id) inner join role r on (ur.role_id=r.role_id) where u.email=?";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .jdbcAuthentication()
            .usersByUsernameQuery(usersQuery)
            .authoritiesByUsernameQuery(rolesQuery)
            .dataSource(dataSource)
            .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/admin/**").hasRole("ADMIN")
            .antMatchers("/user/**").hasAnyAuthority("USER", "ADMIN")
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .defaultSuccessUrl((request, response, authentication) -> {
                Set<String> roles = AuthorityUtils.authorityListToSet(
                    SecurityContextHolder
                        .getContext().getAuthentication().getAuthorities()
                );

                if (roles.contains("ROLE_ADMIN")) {
                    response.sendRedirect("/admin/home");
                } else {
                    response.sendRedirect("/user/home");
                }
            }, true);
    }
}