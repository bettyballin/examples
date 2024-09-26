import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.PrincipalExtractor;
import org.springframework.stereotype.Component;

@Component
public class CustomPrincipalExtractor implements PrincipalExtractor {

    private final UserRepository userRepository;

    @Autowired
    public CustomPrincipalExtractor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Object extractPrincipal(Map<String, Object> map) {
        String username = (String) map.get("preferred_username");
        return userRepository.findByUsername(username);
    }
}

interface UserRepository {
    Object findByUsername(String username);
}