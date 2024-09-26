import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Temp3490 {
    private static final Logger logger = LoggerFactory.getLogger(Temp3490.class);

    public static void main(String[] args) {
        Mono<User> userMono = Mono.just(new User("exampleUser"));
        logger.info("userName :" + userMono.map(User::getUsername).share().block());
    }

    static class User {
        private String username;

        public User(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}