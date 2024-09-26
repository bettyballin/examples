import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.authentication.session.ConcurrentSessionFilter;
import org.springframework.security.web.authentication.session.SessionInformationExpiredEvent;
import org.springframework.security.web.authentication.session.SessionInformationExpiredStrategy;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.DefaultRedirectStrategy;

public class Temp2844 {

    public static void main(String[] args) {
        Temp2844 app = new Temp2844();
        app.concurrentSessionFilter();
    }

    @Bean
    public ConcurrentSessionFilter concurrentSessionFilter() {
        ConcurrentSessionFilter c = new ConcurrentSessionFilter(sessionRegistry(), new SessionInformationExpiredStrategy() {

            @Override
            public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {

                HttpServletRequest request = event.getRequest();
                HttpServletResponse response = event.getResponse();
                SessionInformation info = event.getSessionInformation();

                redirectStrategy().sendRedirect(request, response, "/ejercicios-programacion/");

            }
        });

        return c;
    }

    private SessionRegistryImpl sessionRegistry() {
        return new SessionRegistryImpl();
    }

    private RedirectStrategy redirectStrategy() {
        return new DefaultRedirectStrategy();
    }
}