import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.session.HttpSessionDestroyedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SessionEndedListener implements ApplicationListener<HttpSessionDestroyedEvent> {
    private final ContractorService contractorService;

    @Autowired
    public SessionEndedListener(ContractorService contractorService) {
        this.contractorService = contractorService;
    }

    @Override
    public void onApplicationEvent(HttpSessionDestroyedEvent event) {
        List<SecurityContext> securityContexts = event.getSecurityContexts();
        for (SecurityContext securityContext : securityContexts) {
            // Perform your actions here
        }
    }
}