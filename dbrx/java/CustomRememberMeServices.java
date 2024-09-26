import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationToken;
import org.springframework.security.web.authentication.rememberme.RememberMeServices;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomRememberMeServices implements RememberMeServices {

    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;

    public CustomRememberMeServices(UserDetailsService userDetailsService, AuthenticationManager authenticationManager) {
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication autoLogin(HttpServletRequest request, HttpServletResponse response) {

        // Check for existing remember-me token and validate it.
        RememberMeAuthenticationToken auth =
                (RememberMeAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        if (auth != null && !auth.isAuthenticated()) {
            return null;
        }

        String username = getFromCookie(request);

        if (username == null) {
            return null;
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());

        // Set remember-me flag to true.
        token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        return authenticationManager.authenticate(token);
    }

    @Override
    public void loginFail(HttpServletRequest request, HttpServletResponse response) {
        // Handle failed logins here if needed.
    }

    @Override
    public void loginSuccess(HttpServletRequest request, HttpServletResponse response, Authentication successfulAuthentication) {

        String username = ((UserDetails) successfulAuthentication.getPrincipal()).getUsername();

        // Create a new remember-me token and store it in the cookie or database.

        setCookie(response, username);
    }

    private String getFromCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("remember-me")) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    private void setCookie(HttpServletResponse response, String username) {
        Cookie cookie = new Cookie("remember-me", username);
        cookie.setMaxAge(86400); // expires in 1 day
        response.addCookie(cookie);
    }
}