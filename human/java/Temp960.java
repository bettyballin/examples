import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import java.util.List;

public class Temp960 {

    private SessionFactory sessionFactory; // Assuming you have a sessionFactory initialized

    public static void main(String[] args) {
        // Example usage
        Temp960 temp = new Temp960();
        List<Local> locales = temp.listLocal("userLogin");
        locales.forEach(System.out::println);
    }

    public List<Local> listLocal(String userLogin) {
        Query<Local> query = sessionFactory.getCurrentSession()
              .createQuery("select u.userLocales from User u where u.login = :userLogin", Local.class);
        query.setParameter("userLogin", userLogin);
        return query.list();
    }
}

// Assuming the Local class looks something like this
class Local {
    // Local class implementation
}

// Assuming the User class looks something like this
class User {
    // User class implementation
}