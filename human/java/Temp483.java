public class Temp483 {
    public static void main(String[] args) {
        System.out.println("This is a placeholder for Maven POM configuration.");
    }
}


xml
<properties>
    <spring.framework.version>3.1.2.RELEASE</spring.framework.version>
    <spring.security.version>3.1.1.RELEASE</spring.security.version>
    <spring.webflow.version>2.3.1.RELEASE</spring.webflow.version>
</properties>

<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>${spring.framework.version}</version>
        <type>jar</type>
    </dependency>
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-core</artifactId>
        <version>${spring.security.version}</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-web</artifactId>
        <version>${spring.security.version}</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-config</artifactId>
        <version>${spring.security.version}</version>
    </dependency>
    <dependency>
        <groupId>cglib</groupId>
        <artifactId>cglib</artifactId>
        <version>2.1_3</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.webflow</groupId>
        <artifactId>spring-webflow</artifactId>
        <version>${spring.webflow.version}</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.webflow</groupId>
        <artifactId>spring-binding</artifactId>
        <version>${spring.webflow.version}</version>
    </dependency>
</dependencies>