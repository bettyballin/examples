import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Temp2869 {
    public static void main(String[] args) {
        // Application context setup to test the bean configuration can be added here
    }

    @Bean({"b1", "b2"}) // bean available as 'b1' and 'b2', but not 'myBean'
    public MyBean myBean() {
        // instantiate and configure MyBean obj
        MyBean obj = new MyBean();
        return obj;
    }
}

class MyBean {
    // MyBean class implementation
}