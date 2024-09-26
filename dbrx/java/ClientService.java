import org.springframework.security.oauth2.common.util.RandomValueStringGenerator;

public class ClientService {

    private final RandomValueStringGenerator generator = new RandomValueStringGenerator();

    public String generateClientId() {
        return generator.generate();
    }

    public String generateClientSecret() {
        return generator.generate();
    }

    public static void main(String[] args) {
        ClientService service = new ClientService();
        System.out.println("Client ID: " + service.generateClientId());
        System.out.println("Client Secret: " + service.generateClientSecret());
    }
}


xml
<!-- Add this dependency in your pom.xml if using Maven -->
<dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-oauth2</artifactId>
    <version>2.5.1.RELEASE</version>
</dependency>
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-core</artifactId>
    <version>5.3.23</version>
</dependency>