import java.util.Optional;

public interface BoardPermissionService {
    boolean hasAccessToBoard(String userId, String boardId);
}

@Service
public class DefaultBoardPermissionService implements BoardPermissionService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public boolean hasAccessToBoard(String userId, String boardId) {
        Optional<User> optional = userRepo.findById(userId);
        if (optional.isPresent()) {
            User user = optional.get();
            // Replace with your actual logic to determine if the user has access
            boolean hasAccessToBoard = /* your logic here */;
            return hasAccessToBoard;
        } else {
            return false;
        }
    }
}

// Assuming a UserRepository interface and User class exist
interface UserRepository {
    Optional<User> findById(String userId);
}

class User {
    // Define user properties and methods here
}