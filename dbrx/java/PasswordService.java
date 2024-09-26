Here is the code:


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public String hashPassword(String rawPassword) {
        return encoder.encode(rawPassword);
    }

    public boolean matches(String rawPassword, String encodedPassword) {
        return encoder.matches(rawPassword, encodedPassword);
    }

    // Main method for demonstration purposes
    public static void main(String[] args) {
        PasswordService passwordService = new PasswordService();
        String rawPassword = "mysecretpassword";
        String hashedPassword = passwordService.hashPassword(rawPassword);
        System.out.println("Raw Password: " + rawPassword);
        System.out.println("Hashed Password: " + hashedPassword);
        boolean isMatch = passwordService.matches(rawPassword, hashedPassword);
        System.out.println("Passwords match: " + isMatch);
    }
}


It won't compile as is because of missing dependencies. Here is the corrected code with necessary dependencies:


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordService {
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public String hashPassword(String rawPassword) {
        return encoder.encode(rawPassword);
    }

    public boolean matches(String rawPassword, String encodedPassword) {
        return encoder.matches(rawPassword, encodedPassword);
    }

    // Main method for demonstration purposes
    public static void main(String[] args) {
        PasswordService passwordService = new PasswordService();
        String rawPassword = "mysecretpassword";
        String hashedPassword = passwordService.hashPassword(rawPassword);
        System.out.println("Raw Password: " + rawPassword);
        System.out.println("Hashed Password: " + hashedPassword);
        boolean isMatch = passwordService.matches(rawPassword, hashedPassword);
        System.out.println("Passwords match: " + isMatch);
    }
}


Make sure to include the Spring Security library in your project's classpath to compile and run this code. If you are using Maven, add this to your pom.xml:

xml
<dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-crypto</artifactId>
    <version>5.7.3</version>
</dependency>


Or if you are using Gradle, add this to your build.gradle:

groovy
dependencies {
    implementation 'org.springframework.security:spring-security-crypto:5.7.3'
}