import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.EntityListeners;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "my_table") // Replace with your actual table name
public class MyEntity {
    // Define the fields, constructors, getters, and setters for your entity.
}