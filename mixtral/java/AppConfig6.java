import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {
    // Define beans and other configurations
    @Bean
    public UserInfoService userInfoService() {
        return new UserInfoServiceImpl();
    }
}

// UserInfoService.java
public interface UserInfoService {
    void someMethod();
}

// UserInfoServiceImpl.java
public class UserInfoServiceImpl implements UserInfoService {
    private String someProperty;

    public void setSomeProperty(String someProperty) {
        this.someProperty = someProperty;
    }

    @Override
    public void someMethod() {
        System.out.println("Executing someMethod with property: " + someProperty);
    }
}

// main method to execute the code
public class Main {
    public static void main(String[] args) {
        // Using Java Configuration
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserInfoService userInfoService = context.getBean(UserInfoService.class);
        userInfoService.someMethod();
        context.close();

        // Using XML Configuration
        ClassPathXmlApplicationContext xmlContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserInfoService xmlUserInfoService = (UserInfoService) xmlContext.getBean("userInfoService");
        xmlUserInfoService.someMethod();
        xmlContext.close();
    }
}

// applicationContext.xml
/*
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/aop
           http://www.springframework.org/schema/aop/spring-aop.xsd">

    <aop:aspectj-autoproxy/>

    <bean id="userInfoService" class="com.example.UserInfoServiceImpl">
        <property name="someProperty" value="value"/>
    </bean>
</beans>
*/