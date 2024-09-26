import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import java.util.List;
import javax.inject.Inject;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.In;
import org.jboss.seam.security.Identity;

@Stateful
@Name("dataManager")
public class DataManagerBean implements DataManager {
    
    @In
    private EntityManager entityManager;

    @In
    private Identity identity;

    public List<DataRecord> getDataRecords() {
        String queryStr = "SELECT r FROM DataRecord r WHERE r.sensitive = :isSensitive";
        boolean isSensitive = identity.hasRole("SENSITIVE");
        return entityManager.createQuery(queryStr, DataRecord.class)
                    .setParameter("isSensitive", isSensitive)
                    .getResultList();
    }

    // Other methods and implementations would go here
}