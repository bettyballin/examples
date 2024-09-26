import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.SecurityContextRepository;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

public class Temp362 {
    public static void main(String[] args) {
        new Temp362().configureSecurity();
    }

    public void configureSecurity() {
        try {
            HttpSecurity http = getHttpSecurity();
            http.authorizeRequests().expressionHandler(new CustomExpressionHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private HttpSecurity getHttpSecurity() throws Exception {
        WebSecurityConfigurerAdapter adapter = new WebSecurityConfigurerAdapter() {
            @Override
            protected void configure(HttpSecurity http) throws Exception {
                // No configuration needed here for this example
            }
        };
        adapter.init(new FilterChainProxy(new WebSecurityConfigurerAdapter[]{adapter}));
        return adapter.getHttp();
    }
}

class CustomExpressionHandler implements MethodSecurityExpressionHandler {

    @Override
    public Object filter(Object filterTarget, Expression filterExpression, EvaluationContext evalContext) {
        return null;
    }

    @Override
    public void setReturnObject(Object returnObject, EvaluationContext evalContext) {

    }

    @Override
    public Object getReturnObject(EvaluationContext evalContext) {
        return null;
    }

    @Override
    public Object invoke(MethodInvocation mi, EvaluationContext evalContext) throws Throwable {
        return null;
    }

    @Override
    public void setBeanResolver(BeanResolver br) {

    }

    @Override
    public StandardEvaluationContext createEvaluationContext(Authentication authentication, MethodInvocation mi) {
        return new StandardEvaluationContext();
    }

    @Override
    public StandardEvaluationContext createEvaluationContext(Authentication authentication, org.springframework.security.access.expression.method.MethodInvocation mi) {
        return new StandardEvaluationContext();
    }

    @Override
    public void setExpressionParser(ExpressionParser ep) {

    }

    @Override
    public void setParameterNameDiscoverer(ParameterNameDiscoverer pnd) {

    }
}