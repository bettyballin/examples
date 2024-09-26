import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.authentication;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@SpringBootApplication
public class Temp1620 {

    @Autowired
    private WebApplicationContext webApplicationContext;

    public static void main(String[] args) {
        SpringApplication.run(Temp1620.class, args);
    }

    @Bean
    public UserDetailsManager userDetailsManager() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build());
        return manager;
    }

    @Autowired
    public void run(WebApplicationContext context) throws Exception {
        MockMvc mvc = webAppContextSetup(context).build();

        // use this if CustomUser (principal) implements UserDetails
        UserDetails principal = User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build();
        mvc.perform(get("/").with(user(principal)));

        // otherwise use this
        Authentication auth = new Authentication() {
            // Implement necessary methods here
        };
        mvc.perform(get("/").with(authentication(auth)));
    }
}