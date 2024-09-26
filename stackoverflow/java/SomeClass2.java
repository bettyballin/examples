import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import java.util.List;

public class SomeClass2 {
    private final SessionFactory sessionFactory;

    public SomeClass2(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Local> listLocal(String userLogin) {
        Query<List<Local>> query = sessionFactory.getCurrentSession()
                .createQuery("select u.userLocales from User u where u.login = :login", List.class);
        query.setParameter("login", userLogin);
        return query.getResultList();
    }
}