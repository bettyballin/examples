import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Temp2163 implements CommandLineRunner {

    @Autowired
    private CustomUserDetailsService userDetails;

    public static void main(String[] args) {
        SpringApplication.run(Temp2163.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // You can add your logic here to use userDetails
    }
}

class CustomUserDetailsService {
    // Implement the necessary methods and logic for this service
}