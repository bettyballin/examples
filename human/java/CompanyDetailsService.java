import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
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
        if (company.isPresent()) {
            return new CustomUserDetails(company.get());
        } else {
            throw new UsernameNotFoundException("Company not found");
        }
    }
}

interface CompanyRepo {
    Optional<Company> findByName(String name);
}

class Company {
    private String name;

    // Constructors, getters, and setters
}

class CustomUserDetails implements UserDetails {

    private final Company company;

    public CustomUserDetails(Company company) {
        this.company = company;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return company.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}