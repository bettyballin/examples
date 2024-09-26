import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Main {
    public static void main(String[] args) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        for (int i = 0; i < 5; i++) {
            // "123456" - plain text - user input from user interface
            String passwd = encoder.encode("123456");

            // passwd - password from database
            System.out.println(passwd); // print hash

            // true for all 5 iterations
            System.out.println(encoder.matches("123456", passwd));
        }
    }
}


To execute this code, make sure you have the Spring Security dependency in your project. You can add it to your Maven `pom.xml` like this:

xml
<dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-core</artifactId>
    <version>5.6.3</version> <!-- Make sure to use a compatible version -->
</dependency>


Or if using Gradle, add this to your `build.gradle`:

groovy
implementation 'org.springframework.security:spring-security-core:5.6.3'