import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class WidgetAccessDecisionVoter implements AccessDecisionVoter<Object> {

    @Override
    public int vote(Authentication authentication, Object object, Collection<ConfigAttribute> attributes) {
        // Get the user's authorities
        List<GrantedAuthority> authorities = (List<GrantedAuthority>) authentication.getAuthorities();

        // Check if the user has the appropriate authority to access the widget
        for (ConfigAttribute attribute : attributes) {
            if (attribute.getAttribute().equals("widgetId")) {
                String widgetId = attribute.getAttribute();

                // Check if the user has the authority to access the widget
                boolean hasAccess = authorities.stream()
                        .filter(authority -> authority instanceof WidgetAccessAuthority)
                        .map(authority -> (WidgetAccessAuthority) authority)
                        .map(WidgetAccessAuthority::getWidgetId)
                        .anyMatch(widgetId::equals);

                if (hasAccess) {
                    return ACCESS_GRANTED;
                }
            }
        }

        return ACCESS_DENIED;
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return attribute.getAttribute().equals("widgetId");
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    // Assuming WidgetAccessAuthority is defined somewhere
    public static class WidgetAccessAuthority implements GrantedAuthority {
        private final String widgetId;

        public WidgetAccessAuthority(String widgetId) {
            this.widgetId = widgetId;
        }

        public String getWidgetId() {
            return widgetId;
        }

        @Override
        public String getAuthority() {
            return "WIDGET_ACCESS";
        }
    }
}