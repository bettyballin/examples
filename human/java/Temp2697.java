public class Temp2697 {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}


Replace with the following to make it a Spring Boot Application:

xml
<!-- Add this to your pom.xml -->
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
</dependencies>


And the Java class:


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Temp2697 {
    public static void main(String[] args) {
        SpringApplication.run(Temp2697.class, args);
    }
}