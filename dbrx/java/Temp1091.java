import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public class Temp1091 {

    public static void main(String[] args) {
        // Main method content
    }

    @Repository
    public interface PhonebookRepository extends JpaRepository<Phonebook, Long> {
        Page<Phonebook> findAllByUserEmail(String email, Pageable pageable);
    }

    public static class Phonebook {
        private String userEmail;
        private String phoneNumber;

        public Phonebook() {}

        public Phonebook(String userEmail, String phoneNumber) {
            this.userEmail = userEmail;
            this.phoneNumber = phoneNumber;
        }

        public String getUserEmail() {
            return userEmail;
        }

        public void setUserEmail(String userEmail) {
            this.userEmail = userEmail;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }
}