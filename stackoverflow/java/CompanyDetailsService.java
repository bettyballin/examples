import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.Optional;

public class CompanyDetailsService implements UserDetailsService {

  private final CompanyRepo companyRepo;

  public CompanyDetailsService(CompanyRepo companyRepo) {
    this.companyRepo = companyRepo;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<Company> company = this.companyRepo.findByName(username);
    if (!company.isPresent()) {
      throw new UsernameNotFoundException("Company not found with name: " + username);
    }
    // Convert or cast Company to UserDetails
    UserDetails userDetails = null; // Replace with actual conversion or casting
    return userDetails;
  }
}

interface CompanyRepo {
  Optional<Company> findByName(String name);
}

class Company {
  // Company class implementation
}