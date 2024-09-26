import javax.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Entity
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User creator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }
}

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

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
}

@Repository
interface TableRepository extends JpaRepository<Table, Long> {}

@Repository
interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
}

@Service
public class TableService {
    @Autowired
    private TableRepository tableRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void createTable() {
        Table t = new Table();
        t.setCreator(getCurrentUser());
        tableRepository.save(t);
    }

    public User getCurrentUser() {
        // For the sake of this example, let's assume the current user is always "JohnDoe".
        return userRepository.findByName("JohnDoe");
    }
}