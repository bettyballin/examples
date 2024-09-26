import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootTest
@ContextConfiguration(classes = {MyApp.class})
@Import({NoOpWebSecurityConfig.class})
public class MyTests {

    @Test
    public void contextLoads() {
        // Add your test logic here
    }
}

// Dummy classes to make the code executable

class MyApp {
    // Add your application logic here
}

class NoOpWebSecurityConfig {
    // Add your no-op security configuration here
}