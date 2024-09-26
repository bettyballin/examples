import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public class Temp1672 {
    public static void main(String[] args) {
        // Main method doesn't execute anything for now
    }
}

@Repository
public interface PhonebookRepository extends JpaRepository<PhoneBook, Long> {
    Page<PhoneBook> findAllByUserEmail(String email, Pageable pageable);
}

class PhoneBook {
    // Define the fields and methods for the PhoneBook class
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}