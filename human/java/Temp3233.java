import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.stream.Collectors;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.owasp.encoder.Encode;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private static final int INPUT_LENGTH = 100;
    private static final String MIMETYPE_TEXT_PLAIN_UTF_8 = "text/plain; charset=utf-8";

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int len = req.getContentLength();
        len = Integer.parseInt(Encode.forHtml(String.valueOf(len)));
        String type = req.getContentType();
        type = Encode.forHtml(type);
        Entitlements creds;
        if (len == INPUT_LENGTH && type.equals(MIMETYPE_TEXT_PLAIN_UTF_8)) {
            creds = new ObjectMapper().readValue(req.getReader().lines().collect(Collectors.joining(System.lineSeparator())), Entitlements.class);
        } else {
            creds = new Entitlements();
        }

        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(creds.getId(), "", Collections.emptyList()));
    }

    // Dummy Entitlements class for the sake of compilation
    static class Entitlements {
        public String getId() {
            return "dummyId";
        }
    }
}