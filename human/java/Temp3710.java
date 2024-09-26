// Ensure you have the necessary dependencies and setup for a Spring Boot project.

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Temp3710 {
    public static void main(String[] args) {
        SpringApplication.run(Temp3710.class, args);
    }
}


xml
<!-- Add this to your pom.xml -->
<dependencies>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-bootstrap</artifactId>
    </dependency>
    <!-- Other dependencies -->
</dependencies>

<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>${spring-cloud.version}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>


gradle
// If you are using Gradle, add this to your build.gradle
dependencies {
    implementation 'org.springframework.cloud:spring-cloud-starter-bootstrap'
    // Other dependencies
}

dependencyManagement {
    imports {
        mavenBom "org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}"
    }
}