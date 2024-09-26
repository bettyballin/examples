import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MyService myService = context.getBean(MyService.class);
        myService.doSomething();
        context.close();
    }

    @Bean
    public MyService myService() {
        return new MyService();
    }

    @Bean
    public MyAspect myAspect() {
        return new MyAspect();
    }
}

class MyService {
    public void doSomething() {
        System.out.println("Doing something in MyService");
    }
}

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
class MyAspect {

    @Before("execution(* MyService.doSomething(..))")
    public void beforeAdvice() {
        System.out.println("Before advice is called");
    }
}