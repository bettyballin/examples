import javax.servlet.http.HttpServletResponse;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.ErrorParameter;
import com.vaadin.flow.router.NotFoundException;
import com.vaadin.flow.router.RouteNotFoundError;
import project.vaadin.view.AccessDeniedView;

public class CustomNotFoundTarget extends RouteNotFoundError {

    private static final long serialVersionUID = 3337229943239284836L;

    @Override
    public int setErrorParameter(BeforeEnterEvent event, ErrorParameter<NotFoundException> parameter) {
        event.rerouteTo(AccessDeniedView.class);
        return HttpServletResponse.SC_NOT_FOUND;
    }
}