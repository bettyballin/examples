import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;

import java.util.Collection;

public class CustomAccessDecisionVoter implements AccessDecisionVoter<Object> {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    @Override
    public int vote(Authentication authentication, Object object, Collection<ConfigAttribute> attributes) {

        if (authentication == null || !authentication.isAuthenticated())
            return ACCESS_DENIED;

        User user = ((UserPrincipal) authentication.getPrincipal()).getUser();

        // Check whether the required action is completed

        boolean changeRequiredDoB = userService.checkChangeRequiredDoB(user);

        if (changeRequiredDoB){
            return ACCESS_DENIED;
        }

        // Additional logic can be added here

        return ACCESS_GRANTED;
    }
}