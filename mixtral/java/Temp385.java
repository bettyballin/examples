import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Temp385 {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = "yourPassword"; // User input password
        String dbHashedPassword = "$2a$10$DowJonesIndexEncryptedPassword"; // Hashed password from DB
        
        boolean matches = encoder.matches(password, dbHashedPassword);
        System.out.println("Password matches: " + matches);
        // If true then credentials are valid
    }
}


To make this code executable, ensure you have the Spring Security library in your classpath. You can add the following dependency to your `pom.xml` if you are using Maven:

xml
<dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-core</artifactId>
    <version>5.7.1</version>
</dependency>