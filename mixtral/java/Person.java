import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

// Entity
@Entity
public class Person {
    @Id
    private String id;
    private String name;

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// Repository
@Repository
public interface PersonRepository extends JpaRepository<Person, String> {
    Optional<Person> findById(String id);
    List<Person> findByUuid(UUID uuid);
}

// Controller
@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/getFindByPerson/{uuid}")
    public List<Person> getFindByPerson(@PathVariable UUID uuid) {
        return personRepository.findByUuid(uuid);
    }
}