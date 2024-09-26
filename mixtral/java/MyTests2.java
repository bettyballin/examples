import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = YourController.class)
@Import({YourMapperConfig.class, TestSecurityConfig.class})
public class MyTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testExample() throws Exception {
        // Add your test cases here
    }
}