import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Temp14 {

    @Autowired
    private SessionRegistry sessionRegistry;

    public static void main(String[] args) {
        SpringApplication.run(Temp14.class, args);
    }
}