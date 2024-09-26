import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
public class RoleApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoleApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(RoleProperties roleProperties) {
        return args -> {
            System.out.println("Admin Role: " + roleProperties.getAdminRole());
        };
    }
}

@Configuration
@PropertySource("classpath:application.properties")
class RoleProperties {
    @Value("${role.admin}")
    private String adminRoleName;

    public String getAdminRole() {
        return this.adminRoleName;
    }
}


properties
# application.properties
role.admin=Administrator