import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Temp2445 {
    public static void main(String[] args) {
        SpringApplication.run(Temp2445.class, args);
    }
}

// build.gradle (or build.gradle.kts)
plugins {
    id 'org.springframework.boot' version '2.5.6'
    id 'io.spring.dependency-management' version '1.0.11.RELEASE'
    id 'java'
}

group = 'com.example'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '11'

repositories {
    mavenCentral()
}

dependencies {
    implementation('org.springframework.boot:spring-boot-starter-web')
    implementation('org.springframework.android:spring-android-rest-template:2.0.0.M3') {
        exclude(module = 'spring-android-core')
    }
    implementation('org.springframework.security.oauth:spring-security-oauth2:2.3.0.RC1') {
        exclude(module = 'spring-web')
    }
    testImplementation('org.springframework.boot:spring-boot-starter-test')
}

test {
    useJUnitPlatform()
}