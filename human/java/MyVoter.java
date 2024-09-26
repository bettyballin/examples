import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MyVoter implements AccessDecisionVoter<Entity> {

    @Override
    public boolean supports(ConfigAttribute attribute) {
        boolean myBool = false;
        return myBool;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == Project.class;
    }

    @Override
    public int vote(Authentication authentication, Entity someEntity, Collection<ConfigAttribute> config) {
        if(supports(config)) { // Add this check
            return ACCESS_GRANTED;
        } else {
            return ACCESS_DENIED; // Abstain Based on your requirement
        }
    }
}