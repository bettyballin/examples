import org.springframework.security.access.prepost.PostFilter;
import java.util.List;

public class RecordService1 {

    @PostFilter("hasRole('ROLE_ADMIN') or filterObject.ownerId == authentication.name")
    public List<Record> findAllRecords() {
        // perform query to get all records.
        return null; // Replace with actual query result
    }
}

class Record {
    String ownerId;
    // Other fields, getters, and setters
}