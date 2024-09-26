import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Temp327 {
    public static void main(String[] args) {
        SpringApplication.run(Temp327.class, args);
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String cart() {
        // Your logic here...
        return "Cart Page";
    }
}

Note: Make sure you have the necessary dependencies in your `pom.xml` file (if you're using Maven) or your `build.gradle` file (if you're using Gradle). For example, with Maven:

xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>


Or with Gradle:

groovy
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
}