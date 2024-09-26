import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(
        includeFilters = @ComponentScan.Filter(
                type = FilterType.ASSIGNABLE_TYPE,
                classes = {MyRestController.class, MyRestControllerDependency.class, SecurityTestConfig.class}
        )
)
public class AppConfig {
    // Configuration code here
}