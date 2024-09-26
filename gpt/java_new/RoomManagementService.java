import org.springframework.security.access.prepost.PreAuthorize;

public class RoomManagementService {

    @PreAuthorize("hasRole('ROLE_MANAGER') and @roomSecurityService.isRoomManager(#roomId, principal?.username)")
    public void manageRoom(Long roomId) {
        // business logic to manage room
    }
}