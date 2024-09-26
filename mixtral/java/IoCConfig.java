import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

interface ICustomerDal {
    void add();
}

class MySqlCustomerDal implements ICustomerDal {
    public void add() {
        System.out.println("MySQL database added.");
    }
}

@Configuration
@ComponentScan("com.springdemo")
public class IoCConfig {
    @Bean
    public ICustomerDal database() {
        return new MySqlCustomerDal();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IoCConfig.class);
        ICustomerDal customerDal = context.getBean("database", ICustomerDal.class);
        customerDal.add();
        context.close();
    }
}