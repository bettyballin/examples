import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class Temp661 {

    private String emails_blocked;

    @Autowired
    public Temp661(Environment environment) {
        this.emails_blocked = environment.getProperty("email_blocked");
    }

    public static void main(String[] args) {
        // Spring application context would typically initialize the Temp661 bean
    }
}