import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Main Application
@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo")
public class CustomScopeApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomScopeApplication.class, args);
    }
}

// CustomScopeService Interface
interface CustomScopeService {
    // define service methods here
}

// Service Implementation
@Component
class CustomScopeServiceImpl implements CustomScopeService {

    @Autowired
    private YourRepository repository;

    // ...
}

// Repository Interface
interface YourRepository extends JpaRepository<YourEntity, Long> {}

// Entity Class
@Entity
class YourEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    private String scopes;

    // getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getScopes() {
        return scopes;
    }

    public void setScopes(String scopes) {
        this.scopes = scopes;
    }
}