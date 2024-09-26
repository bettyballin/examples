import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
@SpringBootTest
public class MyTestClass {

   @Autowired
   private MyService myService;

   @Test
   public void testMyService() {
       // Your existing code here
   }
}

// Assuming you have a TestConfig class and a MyService class.

@Configuration
class TestConfig {
   
   @Bean
   public MyService myService() {
       return new MyService();
   }
}

class MyService {
   // Service implementation
}