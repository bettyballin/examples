import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.core.context.SecurityContextImpl;

public class Temp723 {
    public static void main(String[] args) {
        setup();
    }

    public static void setup() {
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                "user", null, AuthorityUtils.createAuthorityList("ROLE_USER"));
        SecurityContextHolder.setStrategy(new SecurityContextHolderStrategy() {
            private SecurityContextImpl context = new SecurityContextImpl();

            @Override
            public void clearContext() {
                context = new SecurityContextImpl();
            }

            @Override
            public SecurityContextImpl getContext() {
                return context;
            }

            @Override
            public void setContext(SecurityContextImpl context) {
                this.context = context;
            }

            @Override
            public SecurityContextImpl createEmptyContext() {
                return new SecurityContextImpl();
            }
        });
        SecurityContextHolder.getContext().setAuthentication(auth);
    }
}