import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.jasig.cas.authentication.handler.support.HttpBasedServiceCredentialsAuthenticationHandler;
import org.apache.commons.httpclient.HttpClient;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        HttpBasedServiceCredentialsAuthenticationHandler handler = 
            (HttpBasedServiceCredentialsAuthenticationHandler) context.getBean("proxyAuthenticationHandler");
        
        // Use the handler as needed
    }
}


xml
<!-- beans.xml -->
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="httpClient" class="org.apache.commons.httpclient.HttpClient"/>

    <bean id="proxyAuthenticationHandler"
          class="org.jasig.cas.authentication.handler.support.HttpBasedServiceCredentialsAuthenticationHandler">
        <property name="httpClient" ref="httpClient"/>
        <property name="requireSecure" value="false"/>
    </bean>

</beans>