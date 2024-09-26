import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.core.Authentication;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    @Autowired
    private GraphTraversalSource g;

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        CustomMethodSecurityExpressionHandler handler = new CustomMethodSecurityExpressionHandler();
        handler.setGraphTraversalSource(g);
        return handler;
    }

    public class CustomMethodSecurityExpressionHandler extends DefaultMethodSecurityExpressionHandler {
        private GraphTraversalSource g;

        public void setGraphTraversalSource(GraphTraversalSource g) {
            this.g = g;
        }

        @Override
        protected MethodSecurityExpressionOperations createSecurityExpressionRoot(Authentication authentication, MethodInvocation invocation) {
            return new CustomMethodSecurityExpressionRoot(authentication, g);
        }
    }
}

class CustomMethodSecurityExpressionRoot extends SecurityExpressionRoot implements MethodSecurityExpressionOperations {

    private GraphTraversalSource g;

    public CustomMethodSecurityExpressionRoot(Authentication authentication, GraphTraversalSource g) {
        super(authentication);
        this.g = g;
    }

    // Implement necessary methods from MethodSecurityExpressionOperations

    @Override
    public void setFilterObject(Object filterObject) {
        // Implementation here
    }

    @Override
    public Object getFilterObject() {
        // Implementation here
        return null;
    }

    @Override
    public void setReturnObject(Object returnObject) {
        // Implementation here
    }

    @Override
    public Object getReturnObject() {
        // Implementation here
        return null;
    }

    @Override
    public Object getThis() {
        // Implementation here
        return null;
    }
}