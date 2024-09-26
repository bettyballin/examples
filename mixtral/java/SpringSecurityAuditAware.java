import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class SpringSecurityAuditAware implements AuditorAware<Long> {

    @Override
    public Optional<Long> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.empty();
        }

        Object principal = authentication.getPrincipal();

        Long userId;

        // Assuming the UserDetails implementation has a getId() method
        if (principal instanceof CustomUser) {
            userId = ((CustomUser) principal).getId();
        } else {
            throw new IllegalStateException("Unexpected type of authentication: " +
                    (authentication.getPrincipal().getClass()));
        }

        return Optional.of(userId);
    }
}

class CustomUser {
    private Long id;

    public CustomUser(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}