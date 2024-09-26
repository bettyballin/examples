import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.domain.ObjectIdentityImpl;
import org.springframework.security.acls.model.MutableAclService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

public class BuildingService {

    @Autowired
    private MutableAclService aclService;

    public List<Building> getObjectsForUser(String username) {
        List<Building> buildings = new ArrayList<>();

        for (Building building : findAllBuildings()) {
            ObjectIdentityImpl objectId = new ObjectIdentityImpl(Building.class, building.getId());

            if (!aclService.readAclsById(objectId).isEmpty() && hasPermission(username)) {
                buildings.add(building);
            }
        }

        return buildings;
    }

    private boolean hasPermission(String username) {
        // Implement your logic to check permissions for the user

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || !auth.isAuthenticated() || !(auth.getPrincipal() instanceof UserDetails))
            return false;

        String principalName = ((UserDetails) auth.getPrincipal()).getUsername();

        // Check permissions for the user
        return principalName.equals(username); // Placeholder logic
    }

    private List<Building> findAllBuildings() {
        // Implement your logic to find all buildings
        return new ArrayList<>(); // Placeholder
    }
}

class Building {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}