import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @PreAuthorize("hasAnyRole('ACCOUNT_OWNER', 'USER')")
    public Address getAddress(Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new NotFoundException(Address.class));
    }
}

interface AddressRepository {
    Optional<Address> findById(Long id);
}

class Address {
    // Address properties and methods
}

class NotFoundException extends RuntimeException {
    public NotFoundException(Class<?> clazz) {
        super(clazz.getSimpleName() + " not found");
    }
}