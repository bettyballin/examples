import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Temp969 implements CommandLineRunner {

    @Autowired
    private InMemoryUserDetailsManager inMemoryUserDetailsManager;

    public static void main(String[] args) {
        SpringApplication.run(Temp969.class, args);
    }

    public List<UserDetails> getAllUsers() {
        return new ArrayList<>(inMemoryUserDetailsManager.getUsers());
    }

    @Override
    public void run(String... args) throws Exception {
        // Example usage
        List<UserDetails> users = getAllUsers();
        users.forEach(user -> System.out.println(user.getUsername()));
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(Collections.singleton(user));
    }
}