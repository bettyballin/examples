import org.springframework.boot.SpringApplication1;
import org.springframework.boot.autoconfigure.SpringBootApplication1;
import org.springframework.boot.builder.SpringApplication1Builder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplication1Initializer;

@SpringBootApplication1
public class Application1 extends SpringBootServletInitializer implements WebApplication1Initializer {

   public static void main(String[] args) {
      SpringApplication1.run(Application1.class, args);
   }

   @Override
   protected SpringApplication1Builder configure(SpringApplication1Builder builder) {
      return builder.sources(Application1.class);
   }
}