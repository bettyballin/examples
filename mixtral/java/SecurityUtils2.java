import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

public final class SecurityUtils {
    public static boolean hasValidIftttServiceKey(String myIftttServiceKey) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes())
            .getRequest();

        String serviceKeyHeader = request.getHeader("IFTTT-Service-Key");

        return Objects.equals(myIftttServiceKey, serviceKeyHeader);
    }
}