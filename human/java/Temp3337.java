import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public class Temp3337 {
    public static void main(String[] args) {
        // The main method can be used to test the implementation if needed
    }

    @Repository
    public interface SsoProviderConfigurationRepository extends JpaRepository<SsoProviderConfiguration, Long> {
        Optional<SsoProviderConfiguration> findByRegistrationId(String code);
    }

    // Dummy class to make the code compile, replace with your actual entity
    public static class SsoProviderConfiguration {
        private Long id;
        private String registrationId;

        // Getters and setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getRegistrationId() {
            return registrationId;
        }

        public void setRegistrationId(String registrationId) {
            this.registrationId = registrationId;
        }
    }
}