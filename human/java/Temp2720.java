import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(
  classes = {SomeApplication.class, SecurityConfiguration.class},
  webEnvironment = WebEnvironment.RANDOM_PORT
)
public class TestApplication {
    // Your test cases here
}