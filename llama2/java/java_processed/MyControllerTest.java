import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(MockitoJUnitRunner.class)
public class MyControllerTest {

  @Mock
  private CustomUserArgumentResolver customUserArgumentResolver;

  @InjectMocks
  private MyController myController; // Assuming MyController is the class under test

  @Test
  public void testSomething() {
    // Your test code here
  }
}