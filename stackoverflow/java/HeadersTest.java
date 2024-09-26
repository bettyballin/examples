import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
        MockServletContext.class,
        HttpSessionConfig.class,
        WebSecurityConfig.class,
        Application.class
}, webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class HeadersTest {
    // Test methods go here
}