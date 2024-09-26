import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity(name = "ripError")
@Table(name = "rip_error", catalog = "database_name")
public class RipError {
    @Id
    private Long id;

    public RipError() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}