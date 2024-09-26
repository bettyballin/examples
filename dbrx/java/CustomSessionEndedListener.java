import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.session.HttpSessionDestroyedEvent;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@Component
public class CustomSessionEndedListener implements ApplicationListener<HttpSessionDestroyedEvent> {
    private final ContractorService contractorService;

    @Autowired
    public CustomSessionEndedListener(ContractorService contractorService) {
        this.contractorService = contractorService;
    }

    @Override
    public void onApplicationEvent(HttpSessionDestroyedEvent sessionDestroyedEvent) {
        List<SecurityContext> securityContexts = new ArrayList<>();
        for (String sessionId : sessionDestroyedEvent.getSessionIds()) {
            HttpSession httpSession = sessionDestroyedEvent.getSession();
            if (httpSession == null || !sessionId.equals(httpSession.getId())) continue;

            Enumeration<String> attributeNames = httpSession.getAttributeNames();
            while (attributeNames.hasMoreElements()) {
                String attributeName = attributeNames.nextElement();
                Object attributeValue = httpSession.getAttribute(attributeName);

                // Check for SecurityContext instances and add them to the list
                if (attributeValue instanceof SecurityContext) securityContexts.add((SecurityContext) attributeValue);
            }
        }

        // sessionDestroyedEvent.getSession().invalidate(); // Commented out to prevent NullPointerException

        // Process your contractorService logic here using 'securityContexts'
    }
}