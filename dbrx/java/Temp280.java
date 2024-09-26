import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.*;

public class Temp280 {
    public static void main(String[] args) {
        // Create SessionFactory
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // Get current session
        Session session = sessionFactory.getCurrentSession();

        try {
            // Begin transaction
            session.beginTransaction();

            // Identifier value for the query
            String identifier = "someIdentifierValue";

            // Create query
            Query query = session.createQuery("from User u where u.identifier = :identifier", User.class);
            query.setParameter("identifier", identifier);

            // Execute the query
            query.list();

            // Commit transaction
            session.getTransaction().commit();
        } finally {
            // Close session
            session.close();
            sessionFactory.close();
        }
    }
}

// User class (assuming it's a simple entity with an identifier field)
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "identifier")
    private String identifier;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}