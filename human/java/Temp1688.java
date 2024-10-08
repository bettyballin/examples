xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:security="http://www.springframework.org/schema/security"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
                           http://www.springframework.org/schema/beans/spring-beans.xsd
                           http://www.springframework.org/schema/security 
                           http://www.springframework.org/schema/security/spring-security.xsd">

    <security:global-method-security metadata-source-ref="customMethodSecurityMetadataSource">
        <!-- Additional configurations can go here -->
    </security:global-method-security>

    <bean id="customMethodSecurityMetadataSource" class="org.springframework.security.access.annotation.SecuredAnnotationSecurityMetadataSource">
        <!-- Additional configurations can go here -->
    </bean>

</beans>