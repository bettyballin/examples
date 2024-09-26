import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class Temp324 {

    private SessionFactory sessionFactory;

    public Temp324() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static void main(String[] args) {
        Temp324 temp = new Temp324();
        try {
            User user = temp.getUserByEmail("example@example.com");
            System.out.println("User found: " + user);
        } catch (UsernameNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public User getUserByEmail(String email) {
        Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.email = :email");
        query.setParameter("email", email);

        List<User> usersList = (List<User>) query.list();

        if (!usersList.isEmpty()) {
            return usersList.get(0);
        } else {
            throw new UsernameNotFoundException("Invalid credentials");
        }
    }

    // Assuming the User class exists with the necessary annotations and fields
    public static class User {
        private String email;
        // other fields, getters, setters, etc.

        @Override
        public String toString() {
            return "User{" +
                    "email='" + email + '\'' +
                    // other fields
                    '}';
        }
    }
}