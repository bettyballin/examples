import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        // Check if the current user is the owner of the item being updated
        if (targetDomainObject instanceof Book && permission.equals("update")) {
            Book book = (Book) targetDomainObject;
            return book.getOwner().equals(authentication.getName());
        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        // Additional logic could be implemented here for other types of permission checks
        return false;
    }
}

class Book {
    private String owner;

    public Book(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }
}