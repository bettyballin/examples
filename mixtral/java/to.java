import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Autowired
    private IAuthRepo authRepo;

    @Bean(name = "realm")
    public ApplicationRealm realm() {
        return new ApplicationRealm(authRepo);
    }
}

public interface IAuthRepo {
    // define repository methods here
}

public class ApplicationRealm {
    private final IAuthRepo authRepo;

    public ApplicationRealm(IAuthRepo authRepo) {
        this.authRepo = authRepo;
    }

    // other methods and logic
}