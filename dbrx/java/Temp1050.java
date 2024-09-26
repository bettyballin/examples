import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Temp1050 {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "yourPassword";
        String storedHash = encoder.encode(rawPassword); // Simulating stored hash, in real scenario this should come from a database

        if (encoder.matches(rawPassword, storedHash)) {
            System.out.println("Password is correct!");
        } else {
            System.out.println("Wrong password.");
        }
    }
}

won't compile without spring-security dependency, adding that using maven

pom.xml:
xml
<dependencies>
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-crypto</artifactId>
        <version>5.7.3</version>
    </dependency>
</dependencies>

Alternatively, if using gradle, use this:

build.gradle:
groovy
dependencies {
    implementation 'org.springframework.security:spring-security-crypto:5.7.3'
}