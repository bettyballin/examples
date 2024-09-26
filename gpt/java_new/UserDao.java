import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.Session;
import java.util.List;
import java.util.ArrayList;

public class UserDao {
    private SessionFactory sessionFactory;

    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public User getUser(String login) {
        List<User> userList;
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery(
                "from User u where u.profileName = :login or u.email = :login", User.class);
            query.setParameter("login", login);
            userList = query.list();
        }
        return userList.isEmpty() ? null : userList.get(0);
    }
}