import org.springframework.security.access.prepost.PostFilter;
import java.util.List;

public class RecordService {

    @PostFilter("filterObject.ownerId == authentication.name")
    public List<Record> findAllRecords() {
        // perform query to get records.
        return null; // Placeholder for the actual query implementation.
    }
}

class Record {
    public String ownerId;
    // Other fields and methods.
}