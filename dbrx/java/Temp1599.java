import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
public class Temp1599Application {
    public static void main(String[] args) {
        SpringApplication.run(Temp1599Application.class, args);
    }
}

@Repository
interface InterventoRepository extends JpaRepository<Intervento, Long> {
    @EntityGraph(attributePaths = {"meccanico"})
    List<Intervento> findAll();
}

@Entity
class Intervento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String meccanico;

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMeccanico() {
        return meccanico;
    }

    public void setMeccanico(String meccanico) {
        this.meccanico = meccanico;
    }
}