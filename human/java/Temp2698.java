public class Temp2698 {
    public static void main(String[] args) {
        System.out.println("This code contains configuration properties intended for a Spring Boot application.");
        System.out.println("These properties cannot be directly executed in a Java main method.");
        System.out.println("Please configure them in application.properties or application.yml file in your Spring Boot project.");
    }
}


For Spring Boot configuration, you should add the properties to your `application.properties` file like this:


endpoints.actuator.enabled=true
endpoints.trace.enabled=true
endpoints.trace.sensitive=false
management.trace.include=request-headers,response-headers,cookies,errors,parameters