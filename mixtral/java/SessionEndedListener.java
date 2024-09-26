import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.session.HttpSessionDestroyedEvent;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.Objects;

@Component
public class SessionEndedListener implements ApplicationListener<HttpSessionDestroyedEvent> {
    private final ContractorService contractorService;

    @Autowired
    public SessionEndedListener(ContractorService contractorService) {
        this.contractorService = contractorService;
    }

    @Override
    public void onApplicationEvent(HttpSessionDestroyedEvent httpSessionDestroyedEvent) {
        HttpSession session = httpSessionDestroyedEvent.getSession();

        if (session != null && !session.isNew() && session.getAttributeNames().hasMoreElements()) {
            // Your code here

            Enumeration<String> attributeNames = session.getAttributeNames();

            while(attributeNames.hasMoreElements()){
                String name = attributeNames.nextElement();

                if (name != null && !"".equalsIgnoreCase(name)) {
                    Object value = httpSessionDestroyedEvent.getSecurityContexts().stream()
                        .map(securityContext -> securityContext.getAttribute("SPRING_SECURITY_CONTEXT"))
                        .filter(Objects::nonNull)
                        .findFirst()
                        .orElseThrow(() -> new IllegalStateException("No Security Context found"));

                    // Your code here using the value
                }
            }

            // Your code here
        }
    }
}