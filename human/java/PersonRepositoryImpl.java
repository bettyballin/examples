import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.Neo4jOperations;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// Assuming the following interfaces and classes exist
interface PersonRepositoryCustom {
    void persist(Person person);
}

class Person {
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}

interface SaltSource {
    Object getSalt();
}

@Repository
public class PersonRepositoryImpl implements PersonRepositoryCustom {

    private final PasswordEncoder passwordEncoder;
    private final SaltSource saltSource;
    private final Neo4jOperations template;

    @Autowired
    public PersonRepositoryImpl(PasswordEncoder passwordEncoder,
                                SaltSource saltSource,
                                Neo4jOperations template) {
        this.passwordEncoder = passwordEncoder;
        this.saltSource = saltSource;
        this.template = template;
    }

    @Override
    @Transactional
    public void persist(Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword(), saltSource.getSalt()));
        template.save(person);
    }
}