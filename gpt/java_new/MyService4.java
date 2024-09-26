import org.springframework.security.access.prepost.PreAuthorize;

public class MyService4 {

    @PreAuthorize("hasAuthority('ROLE_THIRD_PARTY')")
    public void methodAccessibleByThirdPartyRole() {
        // method implementation
    }

    @PreAuthorize("!hasAuthority('ROLE_THIRD_PARTY')")
    public void methodInaccessibleByThirdPartyRole() {
        // method implementation
    }
}