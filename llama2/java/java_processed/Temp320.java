import org.springframework.data.mongodb.repository.MongoRepository;
import org.bson.types.ObjectId;
import java.util.List;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

public class Temp320 {
    public static void main(String[] args) {
    }

    public interface DogRepository extends MongoRepository<Dog, ObjectId> {
        List<Dog> findByOwnerUsername(@AuthenticationPrincipal User user);
    }

    public static class Dog {
        private ObjectId id;
        private String name;

        public ObjectId getId() {
            return id;
        }

        public void setId(ObjectId id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class User {
        private String username;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}