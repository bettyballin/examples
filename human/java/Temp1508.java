xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:security="http://www.springframework.org/schema/security"
       xsi:schemaLocation="
           http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/security
           http://www.springframework.org/schema/security/spring-security.xsd">

    <security:http>
        <security:custom-filter before="FORM_LOGIN_FILTER" ref="subdomainFilter"/>
    </security:http>

    <bean id="subdomainFilter" class="com.example.SubdomainFilter"/>
</beans>