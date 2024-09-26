import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.cycle.AbstractRequestCycleListener;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.request.http.WebResponse;
import org.apache.wicket.request.http.WebRequest;
import org.apache.wicket.request.http.servlet.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyApplication extends WebApplication {
    @Override
    protected void init() {
        super.init();
        getRequestCycleListeners().add(new AbstractRequestCycleListener() {
            @Override
            public void onBeginRequest(RequestCycle cycle) {
                if (cycle.getRequest() instanceof ServletWebRequest) {
                    HttpServletRequest servletRequest = ((ServletWebRequest) cycle.getRequest()).getContainerRequest();
                    HttpServletResponse servletResponse = (HttpServletResponse) cycle.getResponse().getContainerResponse();

                    // Check for session timeout and redirect to login page
                    HttpSession httpSession = servletRequest.getSession(false);
                    if (httpSession == null || !servletRequest.isRequestedSessionIdValid()) {
                        try {
                            servletResponse.sendRedirect(servletRequest.getContextPath() + "/login");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });
    }

    // Main method to start the application
    public static void main(String[] args) {
        WebApplication.run(MyApplication.class, 8080);
    }

    @Override
    public Class<? extends WebPage> getHomePage() {
        return HomePage.class;
    }

    // HomePage class for demonstration
    public static class HomePage extends WebPage {
        public HomePage() {
            add(new Label("message", "Hello, World!"));
        }
    }
}