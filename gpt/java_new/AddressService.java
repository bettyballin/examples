import org.springframework.security.access.prepost.PreAuthorize;
import java.util.Optional;
import java.util.Set;

public class AddressService {

    @PreAuthorize("hasAnyAuthority('ACCOUNT_OWNER', 'USER')")
    public Set getAddresses(Long id) {
        return Optional.ofNullable(addressRepository.findByUserId(id))
            .orElseThrow(() -> new NotFoundException("User profile not found"));
    }

    // Other methods and dependencies would be here, such as addressRepository
    // and the definition for NotFoundException, which is assumed to be a custom exception
}