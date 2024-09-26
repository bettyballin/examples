public class Temp414 {
    public static void main(String[] args) {
        System.out.println("This Java program contains Spring Security XML configuration.");
    }
}

// Save the following Spring Security XML configuration in a separate file, e.g., spring-security-config.xml

/*
<?xml version="1.0" encoding="UTF-8"?>
<beans:beans xmlns="http://www.springframework.org/schema/security"
    xmlns:beans="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
            http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.5.xsd
            http://www.springframework.org/schema/security http://www.springframework.org/schema/security/spring-security-2.0.1.xsd">

    <http pattern="regex">
        <intercept-url pattern="/services/InitechAuthenticationService*" access="ROLE_WSUSER" />
        <intercept-url pattern="/services/InitechAuthenticationService\\?wsdl" filters="none" />
        <http-basic />
    </http>

    <authentication-provider>
        <user-service>
            <user name="internal" password="${WS_USER_INTERNAL_PASSWORD}" authorities="ROLE_WSUSER" />
            <user name="external" password="${WS_USER_EXTERNAL_PASSWORD}" authorities="ROLE_WSUSER" />
        </user-service>
    </authentication-provider>

</beans:beans>
*/