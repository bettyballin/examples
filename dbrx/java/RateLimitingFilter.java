import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.PostConstruct;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

@Component
public class RateLimitingFilter extends OncePerRequestFilter {

    private static final int MAX_REQUESTS_PER_MINUTE = 100;
    private volatile LoadingCache<String, AtomicInteger> requests;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String ipAddress = request.getRemoteAddr();
        AtomicInteger counter = requests.get(ipAddress);
        if (counter.incrementAndGet() > MAX_REQUESTS_PER_MINUTE) {
            // Respond with a 429 Too Many Requests status code
            response.sendError(HttpServletResponse.SC_TOO_MANY_REQUESTS,
                    "You have exceeded the maximum number of allowed requests per minute.");
            return;
        }
        filterChain.doFilter(request, response);
    }

    @PostConstruct
    public void init() {
        // Initialize LoadingCache with desired configuration (e.g., expiration time)
        this.requests = CacheBuilder.newBuilder()
                .expireAfterWrite(1, TimeUnit.MINUTES)
                .build(new CacheLoader<String, AtomicInteger>() {
                    @Override
                    public AtomicInteger load(String key) {
                        return new AtomicInteger(0);
                    }
                });
    }
}