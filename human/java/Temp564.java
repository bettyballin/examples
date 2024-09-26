import org.springframework.web.filter.OncePerRequestFilter;

public class Temp564 {
    public static void main(String[] args) {
        // Example usage of OncePerRequestFilter
        OncePerRequestFilter filter = new OncePerRequestFilter() {
            @Override
            protected void doFilterInternal(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.FilterChain filterChain)
                    throws java.io.IOException, javax.servlet.ServletException {
                // Implement the filter logic here
                filterChain.doFilter(request, response);
            }
        };
        
        System.out.println("OncePerRequestFilter instantiated.");
    }
}