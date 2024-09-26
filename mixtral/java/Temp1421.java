import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@AutoConfigureMockMvc
public class Temp1421 {

    public static void main(String[] args) {
        SpringApplication.run(Temp1421.class, args);
    }

    @RestController
    public static class MyController {

        @PostMapping("/experiences")
        public String postExperience() {
            return "Experience posted";
        }
    }

    @EnableWebSecurity
    public static class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .authorizeRequests()
                .antMatchers("/experiences").authenticated()
                .and()
                .formLogin().and()
                .httpBasic();
        }
    }

    @Autowired
    private MockMvc mockMvc;

    @Bean
    public CommandLineRunner run() {
        return args -> {
            mockMvc.perform(
                post("/experiences")
                    .with(anonymous())
                    .contentType("application/json")
                    .characterEncoding("utf-8"))
                .andExpect(status().isForbidden());
        };
    }
}