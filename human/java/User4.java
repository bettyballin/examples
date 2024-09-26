import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public Long id;

   public Date lastLogin;

   @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
   public List<Profile> identities;

   public User() {
       this.identities = new ArrayList<>();
       this.lastLogin = new Date();
   }

   public User(Profile profile) {
       this();
       this.identities.add(profile);
   }

   public static class Finder<T, U> {
       private Class<T> idType;
       private Class<U> entityType;

       public Finder(Class<T> idType, Class<U> entityType) {
           this.idType = idType;
           this.entityType = entityType;
       }

       // Your finder methods go here, e.g., find by ID, find all, etc.
   }

   public static Finder<String, User> find = new Finder<>(String.class, User.class);

   // Add additional methods for CRUD operations if needed
}

@Entity
@Table(name = "profiles")
class Profile {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public Long id;

   @ManyToOne
   @JoinColumn(name = "user_id")
   public User user;

   // Additional fields and methods for Profile class
}