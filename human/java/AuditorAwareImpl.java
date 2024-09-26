import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

class Person {
    private String userPrincipalName;

    public Person(String userPrincipalName) {
        this.userPrincipalName = userPrincipalName;
    }

    public String getUserPrincipalName() {
        return userPrincipalName;
    }
}

interface PersonRepository {
    Person findByUserPrincipalName(String userPrincipalName);
}

class AuditorAwareImpl implements AuditorAware<Person> {

    @Override
    public Optional<Person> getCurrentAuditor() {
        PersonRepository personRepo = ApplicationContextProvider.getApplicationContext().getBean(PersonRepository.class);
        return Optional.of(personRepo.findByUserPrincipalName(SecurityContextHolder.getContext().getAuthentication().getName() + "@email.com"));
    }
}

@Component(value = "applicationContextProvider")
public class ApplicationContextProvider implements ApplicationContextAware {

    private static class AplicationContextHolder {
        private static final InnerContextResource CONTEXT_PROV = new InnerContextResource();
    }

    private static final class InnerContextResource {

        private ApplicationContext context;

        private void setContext(ApplicationContext context) {
            this.context = context;
        }
    }

    public static ApplicationContext getApplicationContext() {
        return AplicationContextHolder.CONTEXT_PROV.context;
    }

    @Override
    public void setApplicationContext(ApplicationContext ac) {
        AplicationContextHolder.CONTEXT_PROV.setContext(ac);
    }
}