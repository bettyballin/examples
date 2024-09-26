xml
<!-- Ensure this is part of a larger Spring context configuration file -->
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd">

  <bean id="partneriLogicImpl" class="org.springframework.remoting.caucho.HessianProxyFactoryBean">
    <property name="serviceUrl" value="http://localhost:8080/hr.spi.service/hessian/lcspi/lczaj/partneri" />
    <property name="serviceInterface" value="hr.spi.logic.lcspi.lczaj.PartneriLogic" />
    <property name="username" value="${username}" />
    <property name="password" value="${password}" />
  </bean>

</beans>