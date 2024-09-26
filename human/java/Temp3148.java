import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes={EventUpdater.class, EventTypePermission.class})
public class EventUpdaterApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventUpdaterApplication.class, args);
    }
}

class EventUpdater {
    // Implement the class as needed
}

class EventTypePermission {
    // Implement the class as needed
}