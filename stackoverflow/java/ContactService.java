import org.springframework.security.access.prepost.PreAuthorize;

public interface ContactService {

    @PreAuthorize("hasRole('USER')")
    void create(Contact contact);
}

class Contact { // Placeholder for the Contact class definition
    // Contact class members and methods
}