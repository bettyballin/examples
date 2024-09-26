import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
    AppConfig1.class,
    AppConfig2.class
})
public class MyTestClass {

    @Test
    public void testExample() {
        // Example test case
        assertTrue(true);
    }
}

// Example AppConfig1 class
@Configuration
public class AppConfig1 {
    // Beans definitions
}

// Example AppConfig2 class
@Configuration
public class AppConfig2 {
    // Beans definitions
}