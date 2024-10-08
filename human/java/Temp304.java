public class Temp304 {
    public static void main(String[] args) {
        System.out.println("Spring Security Configuration Example");

        // Simulating the XML configuration as a string for demonstration
        String springSecurityConfig = """
        <beans xmlns="http://www.springframework.org/schema/beans" 
               xmlns:security="http://www.springframework.org/schema/security" 
               xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
               xmlns:util="http://www.springframework.org/schema/util" 
               xsi:schemaLocation="http://www.springframework.org/schema/beans 
               http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
               http://www.springframework.org/schema/security 
               http://www.springframework.org/schema/security/spring-security-3.0.4.xsd
               http://www.springframework.org/schema/util 
               http://www.springframework.org/schema/util/spring-util.xsd">

           <security:http>
               <security:intercept-url pattern="/login" access="permitAll"
                   requires-channel="https"/>
           </security:http> 

        </beans>
        """;

        System.out.println(springSecurityConfig);
    }
}