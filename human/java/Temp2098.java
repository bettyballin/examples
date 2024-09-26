import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        MyUserDetailsService myUserDetailsService = (MyUserDetailsService) context.getBean("myUserDetailsService");
        // Use myUserDetailsService as needed
    }
}

// Assuming your.package.hierarcy.goes.here.MyUserDetailsService is a valid class
package your.package.hierarcy.goes.here;

public class MyUserDetailsService {
    // Implementation of the service
}

// beans.xml content
/*
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="myUserDetailsService" class="your.package.hierarcy.goes.here.MyUserDetailsService" />
</beans>
*/