xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd">
  
  <bean id="bean1" class="com.example.Bean1"/>
  <bean id="bean2" class="com.example.Bean2"/>

  <import resource="security-db.xml"/>
  <import resource="foo-db.xml"/>
</beans>