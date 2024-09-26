import org.springframework.security.access.prepost.PreAuthorize;

public interface ContactService1 {

    @PreAuthorize("hasPermission(#contact, 'admin')")
    void deletePermission(Contact contact, Sid recipient, Permission permission);
}