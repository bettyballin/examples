import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IocConfig.class);
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
        System.out.println("Hello, World!");
    }
}