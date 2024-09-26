import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public class Temp3128 {

    @PersistenceContext
    private EntityManager entityManager;

    public static void main(String[] args) {
        Temp3128 temp3128 = new Temp3128();
        String fooId = "exampleFooId";
        Foo foo = temp3128.findFooById(fooId);
        System.out.println(foo);
    }

    public Foo findFooById(String fooId) {
        String queryStr = "select foo from Foo foo where foo.id = :fooId and foo.user.id = :userId";
        TypedQuery<Foo> query = entityManager.createQuery(queryStr, Foo.class);
        query.setParameter("fooId", fooId);
        query.setParameter("userId", getPrincipalId());
        return query.getSingleResult();
    }

    private Long getPrincipalId() {
        // Mock method to return the principal's id
        // In a real application, this would fetch the authenticated user's id
        return 1L;
    }

    // Mock Foo class
    public static class Foo {
        private String id;
        private User user;

        // getters and setters

        @Override
        public String toString() {
            return "Foo{id='" + id + "', user=" + user + '}';
        }
    }

    // Mock User class
    public static class User {
        private Long id;

        // getters and setters
    }
}