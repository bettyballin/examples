import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Temp2247 {

    public static void main(String[] args) {
        Temp2247 temp = new Temp2247();
        String email = "example@example.com";
        Long bitcoins = temp.sumBitcoinsByEmail(email);
        System.out.println("Total bitcoins for " + email + ": " + bitcoins);
    }

    public Long sumBitcoinsByEmail(String email) {
        EntityManager em = Persistence.createEntityManagerFactory("example-unit").createEntityManager();
        String queryStr = "SELECT SUM(u.bitcoins) FROM User u WHERE LOWER(u.email) = LOWER(:email)";
        TypedQuery<Long> query = em.createQuery(queryStr, Long.class);
        query.setParameter("email", email);
        return query.getSingleResult();
    }
}