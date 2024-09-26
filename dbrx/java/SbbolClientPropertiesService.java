import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SbbolClientPropertiesService {

    private final SbbolClientPropertiesRepository repository;

    @Autowired
    public SbbolClientPropertiesService(SbbolClientPropertiesRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void updateSbbolClientSecret(String newClientSecret) {
        Optional<SbbolClientProperties> propertiesOptional = repository.findById(1L);
        propertiesOptional.ifPresent(properties -> {
            properties.setClientSecret(newClientSecret);
            repository.save(properties);
        });
    }
}

// Assuming the existence of the below classes/interfaces

interface SbbolClientPropertiesRepository {
    Optional<SbbolClientProperties> findById(Long id);
    SbbolClientProperties save(SbbolClientProperties properties);
}

class SbbolClientProperties {
    private Long id;
    private String clientSecret;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }
}


Note: The code was already correct. However, I've replaced the `isPresent()` check with `ifPresent()` to make it more concise and expressive. This change does not affect the functionality of the code.