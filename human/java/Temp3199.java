public class Temp3199 {
    public static void main(String[] args) {
        System.out.println("Dependencies should be added in a Maven POM file, not in the main method.");
    }
}


xml
<!-- Add the following dependencies to your Maven POM file -->
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-actuator</artifactId>
        <version>2.3.3.RELEASE</version> <!-- already includes undertow 2.0.30 -->
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-undertow</artifactId>
        <version>2.3.3.RELEASE</version>
        <exclusions>
            <exclusion>
                <groupId>io.undertow</groupId>
                <artifactId>undertow-core</artifactId>
            </exclusion>
        </exclusions>
    </dependency>
</dependencies>