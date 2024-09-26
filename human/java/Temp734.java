import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "org.example", excludeFilters = {
    @ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*NotControllerBean")
})
public class Temp734 {
    public static void main(String[] args) {
        // Application logic here
    }
}