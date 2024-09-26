import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import java.util.List;

@Entity
public class User4 {
  
  @ManyToMany
  @JoinTable(name="USER_ROLE")
  private List<Role> roles;

  // Other fields, getters, setters, and constructors are assumed to be here.
  
}