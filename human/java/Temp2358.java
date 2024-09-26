public class Temp2358 {
    public static void main(String[] args) {
        System.out.println("Spring Security authentication encoding example.");
        // Note: The org.springframework.security.authentication.encoding package is deprecated
        // and removed in Spring Security 5, so here's a sample usage of the new PasswordEncoder interface.

        import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
        import org.springframework.security.crypto.password.PasswordEncoder;

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String rawPassword = "password123";
        String encodedPassword = passwordEncoder.encode(rawPassword);

        System.out.println("Raw Password: " + rawPassword);
        System.out.println("Encoded Password: " + encodedPassword);

        boolean matches = passwordEncoder.matches(rawPassword, encodedPassword);
        System.out.println("Passwords match: " + matches);
    }
}


xml
<!-- Add this to your pom.xml if using Maven -->
<dependencies>
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-core</artifactId>
        <version>5.5.3</version>
    </dependency>
</dependencies>


gradle
// Add this to your build.gradle if using Gradle
dependencies {
    implementation 'org.springframework.security:spring-security-core:5.5.3'
}