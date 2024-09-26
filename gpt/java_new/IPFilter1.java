import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

public class IPFilter1 extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) 
            throws ServletException, IOException {
        // Assuming AuditLogger and AuditMessageType are defined somewhere else in your application
        AuditLogger.log(AuditMessageType.IP_CONNECT, "Detecting connection from IP Address: " + request.getRemoteAddr());
        filterChain.doFilter(request, response);
    }
}

class AuditLogger {
    static void log(AuditMessageType messageType, String message) {
        // Log implementation
    }
}

enum AuditMessageType {
    IP_CONNECT
}