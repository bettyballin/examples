import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebFilter("/*")
public class JsonToUserInfoFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(JsonToUserInfoFilter.class);

    public static class UserInfo {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        if ("application/json".equalsIgnoreCase(request.getContentType())) {
            String jsonStr = request.getReader().lines().collect(Collectors.joining());
            UserInfo userInfo = new ObjectMapper().readValue(jsonStr, UserInfo.class);

            request.setAttribute("username", userInfo.getUsername());
            request.setAttribute("password", userInfo.getPassword());
        }

        chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // No-op
    }

    @Override
    public void destroy() {
        // No-op
    }
}