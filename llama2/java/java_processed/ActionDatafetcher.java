import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@DgsComponent
public class ActionDatafetcher {

    @Autowired
    private ActionService actionService;

    @DgsQuery
    public List<String> actions(@AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        return actionService.getActionsMap(username);
    }
}

// Assuming ActionService is defined as follows:
import org.springframework.stereotype.Component;
import java.util.List;

@Component
class ActionService {
    public List<String> getActionsMap(String username) {
        // Dummy implementation for demonstration
        return List.of("action1", "action2", "action3");
    }
}