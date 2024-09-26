import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"chores", "security"})
public class Temp3117 {
    public static void main(String[] args) {
        System.out.println("Component scanning configured for 'chores' and 'security' packages.");
    }
}