import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;

@SpringBootApplication
public class Temp1871 {

    @Autowired
    private UserRepo userRep;

    // Define bean for UserDetailsServiceImpl
    @Bean
    public UserDetailsService getUserDetailService() {
        return new UserDetailsServiceImpl(userRep);
    }

    public static void main(String[] args) {
        SpringApplication.run(Temp1871.class, args);
    }
}

interface UserRepo {
    // Define repository methods here
}

class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepo userRepo;

    public UserDetailsServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    // Implement methods from UserDetailsService here
}