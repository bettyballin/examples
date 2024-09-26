import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SsoProviderConfigurationRepository extends JpaRepository<SsoProviderConfiguration, Long> {

    Optional<SsoProviderConfiguration> findByRegistrationId(String registrationId);
}