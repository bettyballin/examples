import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import java.util.List;

public class ItemService {

    @PreAuthorize("hasRole('ROLE_USER')")
    public List<Item> findItemsForUser(User user) {
        // ... actual method implementation ...
        return null; // placeholder return statement
    }

    @PostFilter("filterObject.owner == authentication.name")
    public List<Item> findItems() {
        // ... actual method implementation ...
        return null; // placeholder return statement
    }
}

// Assuming the following placeholder classes are defined:
class Item {
    String owner;
    // ... other properties and methods ...
}

class User {
    // ... properties and methods ...
}