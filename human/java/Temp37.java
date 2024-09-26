import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.acegisecurity.intercept.web.FilterSecurityInterceptor;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        FilterSecurityInterceptor filterInvocationInterceptor = (FilterSecurityInterceptor) context.getBean("filterInvocationInterceptor");
        System.out.println("Always Reauthenticate: " + filterInvocationInterceptor.isAlwaysReauthenticate());
    }
}


beans.xml:
xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="filterInvocationInterceptor" class="org.acegisecurity.intercept.web.FilterSecurityInterceptor">
        <property name="alwaysReauthenticate" value="true"/>
    </bean>

</beans>