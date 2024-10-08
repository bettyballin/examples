xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/aop 
           http://www.springframework.org/schema/aop/spring-aop.xsd">

    <bean id="customizableTraceInterceptor" class="org.springframework.aop.interceptor.CustomizableTraceInterceptor">
        <property name="enterMessage" value="Entering $[methodName]($[arguments])"/>
        <property name="exitMessage" value="Leaving $[methodName](): $[returnValue]"/>
    </bean>

    <aop:config>
        <aop:advisor advice-ref="customizableTraceInterceptor" pointcut="execution(public * BankAccountServlet.*(..))"/>
    </aop:config>

</beans>