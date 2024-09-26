import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        DataSource dataSource = (DataSource) context.getBean("dataSource");
        System.out.println("DataSource bean has been initialized: " + dataSource);
    }
}

// DataSource.java
package dao;

public class DataSource {
    // Add your DataSource properties and methods here
    @Override
    public String toString() {
        return "DataSource{}";
    }
}

// beans.xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="dataSource" class="dao.DataSource"/>
</beans>


Ensure you have the required Spring dependencies in your `pom.xml` or `build.gradle` file to run this code successfully.