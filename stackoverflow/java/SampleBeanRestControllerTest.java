import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SampleBeanRestControllerTestConfig.class)
@WebMvcTest(SampleBeanRestController.class)
@AutoConfigureMockMvc
public class SampleBeanRestControllerTest {

   //...

}