import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class PermissionsService {
    private List<String> permissions = Arrays.asList("super", "long", "list");

    public List<String> getPermissions() {
        return permissions;
    }
}

@Service
public class SecurityService {
    private final PermissionsService permissionsService;

    @Autowired
    public SecurityService(PermissionsService permissionsService) {
        this.permissionsService = permissionsService;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    public boolean checkPermission(String permission) {
        return permissionsService.getPermissions().contains(permission);
    }
}