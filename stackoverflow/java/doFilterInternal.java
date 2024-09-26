import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;

public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain, JwtUtils jwtUtils, UserService userService) throws IOException, ServletException {
    String header = request.getHeader(HttpHeaders.AUTHORIZATION);

    if (header == null || !header.startsWith(jwtUtils.getBearer())) {
        chain.doFilter(request, response);
        return;
    }

    String jwt = header.replace(jwtUtils.getBearer(), "");
    String username = jwtUtils.extractUsername(jwt);

    if (username == null && SecurityContextHolder.getContext().getAuthentication() != null) {
        chain.doFilter(request, response);
        return;
    }

    UserDetails user = userService.loadUserByUsername(username);

    if (!jwtUtils.validateToken(jwt, user) || !user.isEnabled()) {
        chain.doFilter(request, response);
        return;
    }

    UsernamePasswordAuthenticationToken passwordAuthToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
    passwordAuthToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
    SecurityContextHolder.getContext().setAuthentication(passwordAuthToken);
    chain.doFilter(request, response);
}