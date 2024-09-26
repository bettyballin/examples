// Assuming the context is a Spring application configuration file
// Here's the complete XML configuration for the FilterChainProxy bean

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:security="http://www.springframework.org/schema/security"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
                           http://www.springframework.org/schema/beans/spring-beans.xsd
                           http://www.springframework.org/schema/security
                           http://www.springframework.org/schema/security/spring-security.xsd">

    <bean id="filterChainProxy" class="org.springframework.security.web.FilterChainProxy">
        <constructor-arg>
            <bean class="java.util.ArrayList">
                <constructor-arg>
                    <list>
                        <bean class="org.springframework.security.web.SecurityFilterChain">
                            <constructor-arg>
                                <value>/secured/**</value>
                            </constructor-arg>
                            <constructor-arg>
                                <list>
                                    <!-- Add your filters here -->
                                    <bean class="org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter"/>
                                </list>
                            </constructor-arg>
                        </bean>
                    </list>
                </constructor-arg>
            </bean>
        </constructor-arg>
    </bean>

</beans>