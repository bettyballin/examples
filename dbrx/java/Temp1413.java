import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SigningKeyResolver;
import io.jsonwebtoken.SigningKeyResolverAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.JwtAuthenticationToken;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Temp1413 {

    private static SigningKeyResolver signingKeyResolver = new SigningKeyResolverAdapter() {
        @Override
        public byte[] resolveSigningKeyBytes(Jwt jwt) {
            // Implement this method to resolve the signing key
            return new byte[0];
        }
    };
    private static String token = "your_token_here";

    public static void main(String[] args) {

        Jwt jwt = Jwts.parserBuilder()
                .setSigningKeyResolver(signingKeyResolver)
                .build()
                .parseClaimsJws(token).getBody();

        Collection<? extends GrantedAuthority> authorities =
                extractAuthorities(jwt.get("authorities"));

        JwtAuthenticationToken authentication = new JwtAuthenticationToken(
                jwt, authorities, null);
        SecurityContextHolder.getContext().setAuthentication(authentication);

    }

    private static Collection<? extends GrantedAuthority> extractAuthorities(Object authorities) {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        if (authorities instanceof List) {
            for (Object authority : (List) authorities) {
                authorityList.add(new SimpleGrantedAuthority((String) authority));
            }
        }
        return authorityList;
    }
}