import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.example")
public class AppConfig {

    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            MyService myService = context.getBean(MyService.class);
            myService.performTask();
        }
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
    public void performTask() {
        System.out.println("Task performed.");
    }
}

@Aspect
class MyAspect {
    @Before("execution(* com.example.MyService.performTask(..))")
    public void beforeTask() {
        System.out.println("Before performing task.");
    }
}


xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="myService" class="com.example.MyService"/>
    <bean id="myAspect" class="com.example.MyAspect"/>
    
    <bean class="org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor">
        <property name="advice" ref="myAspect" />
        <property name="expression" value="execution(* com.example.MyService.performTask(..))" />
    </bean>
    
</beans>


Note: I've added `com.example` to the AspectJ pointcut expression to match the fully qualified name of the `MyService` class. Also, I've added an `AspectJExpressionPointcutAdvisor` bean to the XML configuration to enable the aspect.