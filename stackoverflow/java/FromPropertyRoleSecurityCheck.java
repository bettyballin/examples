import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class FromPropertyRoleSecurityCheck {

  private static final String ROLE_SEPARATOR = ",";

  @Value("${security.rolesAllowed}")
  private String rawRolesAllowed;

  public boolean verifyRoles() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication == null || CollectionUtils.isEmpty(authentication.getAuthorities())) {
      return false;
    }

    Set<String> rolesAllowed = Stream.of(rawRolesAllowed.split(ROLE_SEPARATOR))
                                     .map(String::trim)
                                     .collect(Collectors.toSet());

    return authentication.getAuthorities().stream()
                         .map(GrantedAuthority::getAuthority)
                         .anyMatch(rolesAllowed::contains);
  }
}