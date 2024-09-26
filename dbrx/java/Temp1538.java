import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Optional;

public class Temp1538 {
    public static void main(String[] args) {
        // Main method content here
    }

    @Repository
    public interface UserRepository extends JpaRepository<User, Long> {
        Optional<User> findByCredentialsUsername(String username);

        Boolean existsByCredentialsEmail(String email);
    }

    @Entity
    public static class User {
        @Id
        private Long id;
        @OneToOne
        private Credentials credentials;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Credentials getCredentials() {
            return credentials;
        }

        public void setCredentials(Credentials credentials) {
            this.credentials = credentials;
        }
    }

    @Entity
    public static class Credentials {
        @Id
        private String username;
        private String email;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}