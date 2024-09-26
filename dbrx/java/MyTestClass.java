import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { MyTestClass.MyTestClassConfig.class, MyWebSecurityConfig.class })
public class MyTestClass {

    @Autowired
    private WebApplicationContext webAppContext;

    @Configuration
    public static class MyTestClassConfig {
        // Configuration beans go here
    }

    // ...
}