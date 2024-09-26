import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomFilter2 { // Assuming this is the class name

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        try {
            // Your filter logic here
            chain.doFilter(request, response);
        } catch (Exception e) {
            // Exception handling logic here
        }
    }
}