import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Component
public class ClientIpResolver implements RemoteAddrResolver {

    @Override
    public String resolve(HttpServletRequest request) {
        // Replace these values with actual IPs or patterns you want to match.
        final List<String> allowedIps = Arrays.asList("127.0.0.1", "192.168.1.*");

        for (String ip : allowedIps) {
            if (request.getRemoteAddr().matches(ip.replace("*", ".*"))) {
                return request.getRemoteHost();
            }
        }

        return null;
    }
}

interface RemoteAddrResolver {
    String resolve(HttpServletRequest request);
}