import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Temp1410 {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("my-persistence-unit").createEntityManager();
        Long userId = getPrincipalId(); // Fetch or mock the principal's id
        TypedQuery<Message> query = em.createQuery("select m from Message m where m.to.id = :id", Message.class);
        query.setParameter("id", userId);
        List<Message> messages = query.getResultList();
        messages.forEach(System.out::println);
        em.close();
    }

    private static Long getPrincipalId() {
        // Mocking the principal's id for this example
        return 1L;
    }
}

// Assuming there is a Message class mapped to a database table
@Entity
class Message {
    @Id
    private Long id;
    @ManyToOne
    private User to;
  
    // getters, setters, toString
}

@Entity
class User {
    @Id
    private Long id;
  
    // getters, setters, toString
}


xml
<!-- persistence.xml -->
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence" version="2.1">
    <persistence-unit name="my-persistence-unit">
        <class>Message</class>
        <class>User</class>
        <properties>
            <property name="javax.persistence.jdbc.driver" value="org.h2.Driver"/>
            <property name="javax.persistence.jdbc.url" value="jdbc:h2:mem:test"/>
            <property name="javax.persistence.jdbc.user" value="sa"/>
            <property name="javax.persistence.jdbc.password" value=""/>
            <property name="hibernate.hbm2ddl.auto" value="update"/>
            <property name="hibernate.dialect" value="org.hibernate.dialect.H2Dialect"/>
        </properties>
    </persistence-unit>
</persistence>