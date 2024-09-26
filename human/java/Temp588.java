public class Temp588 {
    public static void main(String[] args) {
        System.out.println("This is just a placeholder main method.");
    }
}


xml
<beans:beans xmlns="http://www.springframework.org/schema/security"
    xmlns:beans="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/security 
    http://www.springframework.org/schema/security/spring-security-4.2.xsd
    http://www.springframework.org/schema/beans 
    http://www.springframework.org/schema/beans/spring-beans-4.2.xsd">

    <security:http auto-config="false" 
                entry-point-ref="authenticationProcessingFilterEntryPoint" 
                access-decision-manager-ref="accessDecisionManager">
    
        <security:custom-filter position="CHANNEL_FILTER" ref="channelProcessingFilter"/>
    
        <security:intercept-url pattern="/*.html*" access="ROLE_ANONYMOUS,admin,user"  />
        <security:intercept-url pattern="/*.jsp" access="ROLE_ANONYMOUS,admin,user" />
    
        <!-- more pattern definition -->
    
    </security:http>

</beans:beans>