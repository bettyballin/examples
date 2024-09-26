import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@SpringBootApplication
public class MyApplication1 {

    public static void main(String[] args) {
        // SpringApplication.run(MyApplication1.class, args);
    }
    
    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer() {
        return RepositoryRestConfigurer.withConfig(config -> {
            config.repositoryDetectionStrategy(RepositoryRestConfigurer.RepositoryDetectionStrategy.ANNOTATED);
        });
    }
}

@RepositoryRestResource(exported = false)
interface UserRepository extends JpaRepository<User, Long> {
    // Repository code here
}

class User {
    // User class implementation
}