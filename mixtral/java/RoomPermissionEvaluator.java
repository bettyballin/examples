import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class RoomPermissionEvaluator implements PermissionEvaluator {

    @Autowired
    private UserService userService;

    @Override
    public boolean hasPermission(Authentication auth, Object targetDomainObject, Object permission) {
        if ("roomManagement".equals(permission)) {
            try {
                return hasRoomManagementAccess(auth, targetDomainObject);
            } catch (AccessDeniedException e) {
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication auth, Serializable targetId, String targetType, Object permission) {
        return false;
    }

    public boolean hasRoomManagementAccess(Authentication auth, Object targetDomainObject) throws AccessDeniedException {
        if (!(targetDomainObject instanceof Room))
            return false;

        String username = ((UserDetails) auth.getPrincipal()).getUsername();
        User user = this.userService.findByUsername(username);

        // Check if the current user is a manager and has access to manage the given room
        // Assuming you have some method in UserService to check this
        return userService.isManagerOfRoom(user, (Room) targetDomainObject);
    }
}

class UserService {
    public User findByUsername(String username) {
        // Implementation to find user by username
        return new User();
    }

    public boolean isManagerOfRoom(User user, Room room) {
        // Implementation to check if the user is a manager of the room
        return true;
    }
}

class User {
    // User class implementation
}

class Room {
    // Room class implementation
}