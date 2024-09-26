import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.DefaultOAuth2AuthenticatedPrincipal;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationProcessingFilter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomOAuth2AuthenticationProcessingFilter extends OAuth2AuthenticationProcessingFilter {

    @Autowired
    private RedisTemplate<String, UserDetails> redisTemplate;

    // ...

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);

        OAuth2AccessToken accessToken = (OAuth2AccessToken) ((DefaultOAuth2AuthenticatedPrincipal) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal()).getAttribute("access_token");

        UserDetails userDetails = redisTemplate.opsForValue().get(
                "access_token:" + accessToken.getTokenValue());

        ((DefaultOAuth2AuthenticatedPrincipal) SecurityContextHolder
                .getContext()
                .getAuthentication().getPrincipal())
                .setUserAuthentication(new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities()));

        chain.doFilter(request, response);
    }
}