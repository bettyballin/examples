import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(IocConfig.class);
        context.refresh();
        
        // Get a bean to verify context is working
        MyBean myBean = context.getBean(MyBean.class);
        myBean.doSomething();
        
        context.close();
    }
}

@Configuration
class IocConfig {
    @Bean
    public MyBean myBean() {
        return new MyBean();
    }
}

class MyBean {
    public void doSomething() {
        System.out.println("Bean is doing something!");
    }
}