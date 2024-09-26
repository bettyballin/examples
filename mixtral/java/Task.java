import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;

// Assuming BaseEntity has an id field which is common for all entities
@MappedSuperclass
abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

@Entity
public class Task extends BaseEntity{
   // other properties

  @Column(name = "user_id")
  private String userId;

  public void setUserId(String userId) {
      this.userId = userId;
  }

  public String getUserId() {
      return userId;
  }

  public static void main(String[] args) {
      Task task = new Task();
      task.setUserId("12345");
      System.out.println("User ID: " + task.getUserId());
  }
}