import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.filter.CompositeFilter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SecurityFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Security logic here
        filterChain.doFilter(request, response);
    }
}

public class BeforeFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Before logic here
        filterChain.doFilter(request, response);
    }
}

public class AfterFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        filterChain.doFilter(request, response);
        // After logic here
    }
}

public class MyHttpConfiguration {

    public void configureHttpFilters(CompositeFilter compositeFilter) {
        List<OncePerRequestFilter> filters = new ArrayList<>();
        filters.add(new BeforeFilter());
        filters.add(new SecurityFilter());
        filters.add(new AfterFilter());

        compositeFilter.setFilters(filters);
    }

    public static void main(String[] args) {
        CompositeFilter compositeFilter = new CompositeFilter();
        MyHttpConfiguration config = new MyHttpConfiguration();
        config.configureHttpFilters(compositeFilter);
        // Now compositeFilter contains BeforeFilter, SecurityFilter, and AfterFilter in the specified order
    }
}