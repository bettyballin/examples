import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(IoCConfig.class);
        context.refresh();
        ICustomerDal customerDal = context.getBean("database", ICustomerDal.class);
        customerDal.add();
        context.close();
    }
}

// Assuming you have IoCConfig and ICustomerDal defined somewhere in your project

// Example IoCConfig
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IoCConfig {

    @Bean(name = "database")
    public ICustomerDal customerDal() {
        return new CustomerDal();
    }
}

// Example ICustomerDal interface
public interface ICustomerDal {
    void add();
}

// Example CustomerDal class implementing ICustomerDal
public class CustomerDal implements ICustomerDal {
    @Override
    public void add() {
        System.out.println("Customer added.");
    }
}