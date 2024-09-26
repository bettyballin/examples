import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.page.Page;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.ErrorParameter;
import com.vaadin.flow.router.HasErrorParameter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException; // added import statement

@Component
public class CustomAccessDeniedExceptionHandler implements HasErrorParameter<AccessDeniedException> {

    @Override
    public int setErrorParameter(BeforeEnterEvent event, ErrorParameter<AccessDeniedException> parameter) {
        UI.getCurrent().navigate("/access-denied");
        return HttpServletResponse.SC_FORBIDDEN;
    }
}