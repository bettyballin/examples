import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.server.ErrorHandler;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

public class MainUI extends UI implements ErrorHandler {
    private static final long serialVersionUID = 1L;

    @Override
    protected void init(VaadinRequest request) {
        VaadinSession.getCurrent().setErrorHandler(this);
        @SuppressWarnings("unused")
        Navigator navigator = new Navigator(this, this);
        // Add your views here
        navigator.addView(FirstView.NAME, FirstView.class);
    }

    @Override
    public void error(com.vaadin.server.ErrorEvent event) {
        Throwable throwable = event.getThrowable();
        while (throwable != null) {
            if (throwable instanceof AccessDeniedException) {
                AccessDeniedException accessDeniedException = (AccessDeniedException) throwable;
                Notification.show(accessDeniedException.getMessage(), Notification.Type.ERROR_MESSAGE);
                getUI().getNavigator().navigateTo(FirstView.NAME);
                return;
            }
            throwable = throwable.getCause();
        }
    }

    public static class AccessDeniedException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public AccessDeniedException(String message) {
            super(message);
        }
    }

    public static class FirstView extends com.vaadin.ui.VerticalLayout implements View {
        public static final String NAME = "firstView";

        public FirstView() {
            addComponent(new com.vaadin.ui.Label("This is the first view"));
        }
    }
}