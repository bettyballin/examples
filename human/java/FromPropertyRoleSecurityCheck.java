import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toSet;

@Component
public class FromPropertyRoleSecurityCheck {

  private final static String ROLE_SEPARATOR = ",";

  @Value("${security.rolesAllowed}")
  private String rawRolesAllowed;


  public boolean verifyRoles() {
    return getPrincipalAuthorities()
            .map(auth -> {
                Set<String> rolesAllowed = Stream.of(rawRolesAllowed.split(ROLE_SEPARATOR))
                        .map(String::trim)
                        .collect(toSet());
                return verifyAllowedRoles(rolesAllowed, auth);
            })
            .orElse(false);
  }


  private Optional<Collection<? extends GrantedAuthority>> getPrincipalAuthorities() {
    return ofNullable(SecurityContextHolder.getContext())
            .map(SecurityContext::getAuthentication)
            .map(Authentication::getAuthorities);
  }


  private boolean verifyAllowedRoles(final Collection<String> rolesAllowed,
                                     final Collection<? extends GrantedAuthority> principalAuthorities) {
    if (CollectionUtils.isEmpty(rolesAllowed)) {
        return true;
    }
    if (CollectionUtils.isEmpty(principalAuthorities)) {
        return false;
    }
    Set<String> rolesDiff = principalAuthorities.stream().map(GrantedAuthority::getAuthority).collect(toSet());
    rolesDiff.removeAll(rolesAllowed);
    return rolesDiff.size() != principalAuthorities.size();
  }

}