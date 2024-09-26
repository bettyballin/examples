import io.ebean.Model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User2 extends Model {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public Long id;

   @Temporal(TemporalType.TIMESTAMP)
   public Date lastLogin;

   @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
   public List<Profile> identities;

   public User2(Profile profile) {
       identities = new ArrayList<>();
       this.identities.add(profile);
       lastLogin = new Date();
   }

   public static final Finder<Long, User2> find = new Finder<>(User2.class);
}