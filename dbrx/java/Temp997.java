import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@SpringBootApplication
public class Temp997Application extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(Temp997Application.class, args);
    }

    @Autowired
    private RoleRepository roleRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        List<Role> adminRoles = roleRepository.findByRoleName("ADMIN");
        String[] adminUrls = new String[adminRoles.size()];
        for (int i = 0; i < adminRoles.size(); i++) {
            adminUrls[i] = "/admin/" + adminRoles.get(i).getUrl();
        }

        http.authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .antMatchers(adminUrls).hasAnyRole("ADMIN")
                .anyRequest().authenticated();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withDefaultPasswordEncoder()
                .username("user").password("password").roles("USER").build());
        manager.createUser(User.withDefaultPasswordEncoder()
                .username("admin").password("admin").roles("ADMIN").build());
        return manager;
    }
}

@Repository
interface RoleRepository extends JpaRepository<Role, String> {
    List<Role> findByRoleName(String roleName);
}

@Entity
class Role {
    @Id
    private String roleName;
    private String url;

    public Role() {}

    public Role(String roleName, String url) {
        this.roleName = roleName;
        this.url = url;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}