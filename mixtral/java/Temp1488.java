import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;
import javax.persistence.Entity;
import javax.persistence.Id;

@SpringBootApplication
public class Temp1488 implements CommandLineRunner {

    @Autowired
    private ProductRepo productRepo;

    public static void main(String[] args) {
        SpringApplication.run(Temp1488.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Example usage of updateVisit method
        productRepo.updateVisit(1L, 100L);
    }
}

@Entity
class ProductEntity {
    @Id
    private Long id;
    private Long visit;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVisit() {
        return visit;
    }

    public void setVisit(Long visit) {
        this.visit = visit;
    }
}

@Repository
interface ProductRepo extends JpaRepository<ProductEntity, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE ProductEntity p SET p.visit = :visit WHERE p.id = :id")
    void updateVisit(@Param("id") long productId, @Param("visit") long newVisits);
}