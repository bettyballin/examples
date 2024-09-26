import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootApplication
@ContextConfiguration
public class Temp3663 {

    public static void main(String[] args) {
        SpringApplication.run(Temp3663.class, args);
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withUsername("user")
                .password("{noop}password")
                .authorities(Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")))
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    @RestController
    @RequestMapping("/person")
    public class PersonController {

        @PostMapping("/{id}")
        public String createPerson() {
            return "Person created";
        }
    }
}

class Temp3663Test {

    public static void main(String[] args) throws Exception {
        WebApplicationContext context = SpringApplication.run(Temp3663.class);
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();

        Authentication userAuthCredentials = user("user").password("password").authorities(new SimpleGrantedAuthority("ROLE_USER")).build();

        mockMvc.perform(post(String.format("/person/%s", "100"))
                .with(csrf())
                .with(SecurityMockMvcRequestPostProcessors.authentication(userAuthCredentials)))
                .andReturn();
    }
}