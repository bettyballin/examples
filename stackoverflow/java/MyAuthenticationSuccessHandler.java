import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.core.Authentication;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.Map;
import java.util.HashMap;

public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Map<String, Authentication> sessionAuthMap = new HashMap<>();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication)
            throws ServletException, IOException {
        lock.writeLock().lock();
        try {
            sessionAuthMap.put(request.getSession().getId(), authentication);
        } finally {
            lock.writeLock().unlock();
        }
        super.onAuthenticationSuccess(request, response, authentication);
    }
}