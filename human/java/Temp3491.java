import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Temp3491 {
    private static final Logger logger = LoggerFactory.getLogger(Temp3491.class);

    public static void main(String[] args) {
        Mono<User> userMono = Mono.just(new User("john_doe"));

        userMono.subscribe(user -> logger.info("username: " + user.getUsername()));
    }
}

class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}


To run this code, ensure you have the necessary dependencies for SLF4J and Reactor Core in your project. For example, using Maven, you can add the following to your `pom.xml`:

xml
<dependencies>
    <!-- SLF4J dependencies -->
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
        <version>1.7.32</version>
    </dependency>
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-simple</artifactId>
        <version>1.7.32</version>
    </dependency>

    <!-- Reactor Core dependency -->
    <dependency>
        <groupId>io.projectreactor</groupId>
        <artifactId>reactor-core</artifactId>
        <version>3.4.10</version>
    </dependency>
</dependencies>