import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

public class Temp2058 {

    public static void main(String[] args) {
        try {
            new Temp2058().doFilter(null, null, null);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    public void doFilter(HttpServletRequest servletRequest, HttpServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest,
                new HttpServletResponseWrapper(servletResponse) {
                    @Override
                    public void setHeader(String name, String value) {
                        if (!"ETag".equalsIgnoreCase(name)) {
                            super.setHeader(name, value);
                        }
                    }
                });
    }
}