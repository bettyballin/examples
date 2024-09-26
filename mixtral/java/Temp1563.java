import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootApplication
public class Temp1563 {

    public static void main(String[] args) {
        SpringApplication.run(Temp1563.class, args);
    }

    @Bean
    CommandLineRunner run(FooService service) {
        return args -> service.findFoo(1L);
    }
}

@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/api/foo").authenticated()
                .anyRequest().permitAll()
            .and()
            .httpBasic();
    }
}

@Service
class FooService {
    public void findFoo(Long id) {
        System.out.println("Finding foo with id: " + id);
    }
}

@RestController
class FooController {

    @Autowired
    private FooService fooService;

    @GetMapping("/api/foo")
    public String getFoo() {
        fooService.findFoo(1L);
        return "Foo";
    }
}

@SpringBootTest
class Temp1563Tests {

    @Autowired
    private FooService service;

    @Test
    @WithMockUser(username = "user", password = "password")
    public void someTest() {
        service.findFoo(1L);
    }
}