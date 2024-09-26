import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

public class Main {
    public static void main(String[] args) throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        LdapTemplate ldapTemplate = (LdapTemplate)context.getBean("ldapTemplate");

        // use the template for your LDAP operations
    }
}


xml
<!-- application-context.xml -->
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="contextSource" class="org.springframework.ldap.core.support.LdapContextSource">
        <property name="url" value="ldap://your-ldap-url" />
        <property name="base" value="dc=example,dc=com" />
        <property name="userDn" value="cn=admin,dc=example,dc=com" />
        <property name="password" value="password" />
    </bean>
    
    <bean id="ldapTemplate" class="org.springframework.ldap.core.LdapTemplate">
        <constructor-arg ref="contextSource" />
    </bean>

</beans>