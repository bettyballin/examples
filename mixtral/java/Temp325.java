import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Temp325 {
    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
        // Example usage
        Temp325 temp = new Temp325();
        User user = temp.getUserByNameOrProfileName("example");
        if (user != null) {
            System.out.println("User found: " + user.getName());
        } else {
            System.out.println("User not found.");
        }
    }

    public User getUserByNameOrProfileName(String input) {
        Query query = sessionFactory.getCurrentSession().createQuery("from User u where (u.name=:input OR u.profileName=:input)");

        // Set the parameter
        query.setParameter("input", input);

        List<User> usersList = query.list();

        if (!usersList.isEmpty()) {
            return usersList.get(0);
        } else {
            return null;
        }
    }
}

// Assuming User class is defined somewhere
class User {
    private String name;
    private String profileName;

    public String getName() {
        return name;
    }

    public String getProfileName() {
        return profileName;
    }
}