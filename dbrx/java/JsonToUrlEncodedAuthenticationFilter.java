import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Component
@Order(value = Integer.MIN_VALUE)
public class JsonToUrlEncodedAuthenticationFilter implements Filter {

    private static final String FILTER_APPLIED_FLAG_NAME = "JsonToUrlEncodedAuthenticationFilter.applied";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization logic can go here if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        if (request instanceof HttpServletRequest && isContentTypeJson(request)) {
            HttpSession session = ((HttpServletRequest) request).getSession(false);
            boolean filterAlreadyApplied;

            // Check the flag in the current HTTP session
            if (session != null) {
                Object appliedFlagValue = session.getAttribute(FILTER_APPLIED_FLAG_NAME);

                if (appliedFlagValue instanceof Boolean) {
                    filterAlreadyApplied = (Boolean) appliedFlagValue;
                } else {
                    filterAlreadyApplied = false; // Default value when the flag is not present
                }
            } else {
                filterAlreadyApplied = false; // No session available so apply the filter by default
            }

            if (!filterAlreadyApplied) { // Only execute this block once per request

                InputStream inputStream = request.getInputStream();
                ByteArrayOutputStream buffer = new ByteArrayOutputStream();

                int nRead;
                byte[] data = new byte[16384];

                while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
                    buffer.write(data, 0, nRead);
                }
                buffer.flush();
                byte[] jsonBytes = buffer.toByteArray(); // Save the JSON bytes for later use

                Map<String, String[]> result;
                try (JsonParser parser = new ObjectMapper().getFactory().createParser(jsonBytes)) {
                    result = parser.readValueAs(new TypeReference<Map<String, String[]>>() {});
                }

                HttpServletRequest wrappedRequest = new MyServletRequestWrapper((HttpServletRequest) request, result);
                session.setAttribute(FILTER_APPLIED_FLAG_NAME, true); // Mark the filter as applied
                chain.doFilter(wrappedRequest, response);
                return;
            }
        }
        chain.doFilter(request, response);
    }

    private boolean isContentTypeJson(ServletRequest request) {
        String contentType = request.getContentType();
        return contentType != null && contentType.contains("application/json");
    }

    @Override
    public void destroy() {
        // Cleanup logic can go here if needed
    }

    private static class MyServletRequestWrapper extends HttpServletRequestWrapper {
        private final Map<String, String[]> formData;

        MyServletRequestWrapper(HttpServletRequest request, Map<String, String[]> formData) {
            super(request);
            this.formData = formData;
        }

        @Override
        public String getParameter(String name) {
            String[] values = formData.get(name);
            return (values != null && values.length > 0) ? values[0] : null;
        }

        @Override
        public String[] getParameterValues(String name) {
            return formData.get(name);
        }

        @Override
        public Map<String, String[]> getParameterMap() {
            return formData;
        }
    }
}