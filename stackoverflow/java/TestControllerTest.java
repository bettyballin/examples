import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;

@WebMvcTest(TestController.class)
@Import({TestControllerTest.Config.class})
public class TestControllerTest {
     @Configuration
     public static class Config {
        @Bean(name="SecurityService")
        public SecurityService securityService() {
            return new SecurityService();
        }
     }
}