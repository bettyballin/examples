import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ServiceProperties {
    private String serviceRelativeUrl;
    private String validDomainPattern;

    public void setServiceRelativeUrl(String serviceRelativeUrl) {
        this.serviceRelativeUrl = serviceRelativeUrl;
    }

    public String getServiceRelativeUrl() {
        return serviceRelativeUrl;
    }

    public void setValidDomainPattern(String validDomainPattern) {
        this.validDomainPattern = validDomainPattern;
    }

    public String getValidDomainPattern() {
        return validDomainPattern;
    }

    @Override
    public String toString() {
        return "ServiceProperties{" +
                "serviceRelativeUrl='" + serviceRelativeUrl + '\'' +
                ", validDomainPattern='" + validDomainPattern + '\'' +
                '}';
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ServiceProperties serviceProperties = (ServiceProperties) context.getBean("serviceProperties");
        System.out.println(serviceProperties);
    }
}


xml
<!-- applicationContext.xml -->
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="serviceProperties" class="ServiceProperties">
        <property name="serviceRelativeUrl" value="/my_cas_callback" />
        <property name="validDomainPattern" value="*.mydomain.com" />
    </bean>

</beans>