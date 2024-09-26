import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.WebSecurityExpressionRoot;

import javax.servlet.http.HttpSession;

public class CustomWebSecurityExpressionRoot extends WebSecurityExpressionRoot {
    private final HttpSession session;

    public CustomWebSecurityExpressionRoot(Authentication a, FilterInvocation fi, HttpSession session) {
        super(a, fi);
        this.session = session;
    }

    public HttpSession getSession() {
        return session;
    }
}

public class CustomSecurityExpressionHandler extends DefaultWebSecurityExpressionHandler {
    private final HttpSession session;

    public CustomSecurityExpressionHandler(HttpSession session) {
        this.session = session;
    }

    @Override
    protected WebSecurityExpressionRoot createSecurityExpressionRoot(Authentication authentication, FilterInvocation fi) {
        CustomWebSecurityExpressionRoot root = new CustomWebSecurityExpressionRoot(authentication, fi, session);
        return root;
    }
}