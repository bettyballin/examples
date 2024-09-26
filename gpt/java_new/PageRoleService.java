import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageRoleService {

    @Autowired
    private PageRoleRepository pageRoleRepository;

    public List<String> getRolesForPage(String pageUrl) {
        return pageRoleRepository.findRolesByPageUrl(pageUrl);
    }
}

@Service
public class CustomSecurityService {

    @Autowired
    private PageRoleService pageRoleService;

    @Autowired
    private AuthenticationTrustResolver authenticationTrustResolver;

    public boolean hasAccess(String pageUrl) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // Your logic to determine access based on authentication and roles goes here
        // This is a placeholder return statement
        return true;
    }
}