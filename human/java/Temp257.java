import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SimpleUrlLogoutSuccessHandler myLogoutSuccessHandler = (SimpleUrlLogoutSuccessHandler) context.getBean("myLogoutSuccessHandler");
        System.out.println("Default Target URL: " + myLogoutSuccessHandler.getDefaultTargetUrl());
        System.out.println("Always Use Default Target URL: " + myLogoutSuccessHandler.isAlwaysUseDefaultTargetUrl());
    }
}


xml
<!-- applicationContext.xml -->
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="myLogoutSuccessHandler" class="org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler">
        <property name="defaultTargetUrl" value="/" />
        <property name="alwaysUseDefaultTargetUrl" value="true" />
    </bean>

</beans>