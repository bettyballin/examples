import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<Person> {

    private static final ThreadLocal<Optional<Person>> CURRENT_USER = new InheritableThreadLocal<>();

    @Autowired
    private PersonRepository personRepo;

    public void setCurrentUser(String userPrincipalName) {
        Optional<Person> currentAuditor = getFromCacheOrFetchAndStoreInCache(userPrincipalName);
        CURRENT_USER.set(currentAuditor);
    }

    private Optional<Person> getFromCacheOrFetchAndStoreInCache(String userPrincipalName) {

        if (CURRENT_USER.get() != null && !CURRENT_USER.get().isEmpty())
            return CURRENT_USER.get();

        Person person = personRepo
                .findByUserPrincipalName(userPrincipalName + "@email.com")
                .orElseThrow(() -> new RuntimeException("Could not find user"));

        Optional<Person> currentAuditor = Optional.ofNullable(person);
        CURRENT_USER.set(currentAuditor);
        return currentAuditor;
    }

    @Override
    public Optional<Person> getCurrentAuditor() {

        if (CURRENT_USER.get() != null && !CURRENT_USER.get().isEmpty())
            return CURRENT_USER.get();

        throw new RuntimeException("Could not find current auditor");
    }
}

// Assuming the existence of Person and PersonRepository classes

class Person {
    // Implementation of the Person class
}

interface PersonRepository {
    Optional<Person> findByUserPrincipalName(String userPrincipalName);
}