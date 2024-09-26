// Add the necessary dependencies in build.gradle or pom.xml file

// build.gradle
/*
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-security:3.1.2'
    implementation 'org.springframework.boot:spring-boot-starter-oauth2-resource-server:3.1.2'
}
*/

// pom.xml
/*
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
        <version>3.1.2</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-oauth2-resource-server</artifactId>
        <version>3.1.2</version>
    </dependency>
</dependencies>
*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Temp3692 {
    public static void main(String[] args) {
        SpringApplication.run(Temp3692.class, args);
    }
}