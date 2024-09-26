import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;

@Entity
public class Intervento {
    // ...

    @ManyToOne(cascade = CascadeType.ALL) // Or the appropriate CascadeType
    private Meccanico meccanico;

    // Other fields, getters, setters, etc.
}