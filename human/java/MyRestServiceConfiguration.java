import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
// @EnableWebMvc
@Import(MyServiceConfiguration.class)
public class MyRestServiceConfiguration {

}