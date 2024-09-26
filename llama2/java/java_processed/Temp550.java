import org.springframework.web.util.HtmlUtils;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Temp550 {

    private static final EntityManager entityManager = Persistence.createEntityManagerFactory("default").createEntityManager();

    public static void main(String[] args) {
        String queryString = "SELECT e FROM Entity e";
        StringBuffer sanitizedQuery = new StringBuffer();
        sanitizedQuery.append(HtmlUtils.htmlEscape(queryString));

        // Assuming there is an entity class called "Entity"
        TypedQuery<Entity> query = entityManager.createQuery(queryString, Entity.class);
        List<Entity> result = query.getResultList();

        for (Entity entity : result) {
            System.out.println(entity);
        }
    }
}

// Dummy Entity class for demonstration
@Entity
class Entity {
    @Override
    public String toString() {
        return "Entity{}";
    }
}