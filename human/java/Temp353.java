public class Temp353 {
    public static void main(String[] args) {
        System.out.println("This is a placeholder for the security configuration.");
    }
}

// Note: The below XML configuration should be part of an application context XML file for Spring Security configuration, not part of the Java code.

<?xml version="1.0" encoding="UTF-8"?>
<beans:beans xmlns:beans="http://www.springframework.org/schema/beans"
             xmlns:security="http://www.springframework.org/schema/security"
             xmlns:cloudseal="http://www.cloudseal.com/schema/security"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="
                http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
                http://www.springframework.org/schema/security http://www.springframework.org/schema/security/spring-security.xsd
                http://www.cloudseal.com/schema/security http://www.cloudseal.com/schema/security/cloudseal-security.xsd">

    <security:http entry-point-ref="cloudseal">
        <security:intercept-url pattern="/protected/user.do" access="IS_AUTHENTICATED_FULLY" />
        <security:intercept-url pattern="/protected/admin.do" access="ROLE_ADMIN" />
    </security:http>

    <cloudseal:sso endpoint="http://cloudseal.com" entry-point-id="cloudseal" app-id="quickstart">
        <cloudseal:keystore location="WEB-INF/keystore.jks" password="nalle123">
            <cloudseal:key name="apollo" password="nalle123" />
        </cloudseal:keystore>
        <cloudseal:metadata location="WEB-INF/idp.xml" />
    </cloudseal:sso>

</beans:beans>