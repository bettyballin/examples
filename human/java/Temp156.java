xml
<beans:beans xmlns="http://www.springframework.org/schema/security"
             xmlns:beans="http://www.springframework.org/schema/beans"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="
                http://www.springframework.org/schema/beans 
                http://www.springframework.org/schema/beans/spring-beans.xsd
                http://www.springframework.org/schema/security 
                http://www.springframework.org/schema/security/spring-security.xsd">

    <security:http auto-config="true" use-expressions="true" access-denied-page="/krams/auth/denied">
        <security:intercept-url pattern="/krams/auth/login" access="permitAll"/>
        <security:intercept-url pattern="/krams/main/admin" access="hasRole('ROLE_ADMIN')"/>
        <security:intercept-url pattern="/krams/main/common" access="hasRole('ROLE_USER')"/>
    </security:http>

</beans:beans>