import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OptionalAdapterMethodSecurityExpressionHandler implements MethodSecurityExpressionHandler {

    private final MethodSecurityExpressionHandler handler;

    public OptionalAdapterMethodSecurityExpressionHandler(MethodSecurityExpressionHandler handler) {
        this.handler = handler;
    }

    @Autowired
    public OptionalAdapterMethodSecurityExpressionHandler(ApplicationContext applicationContext) {
        this(new DefaultMethodSecurityExpressionHandler());
        ((DefaultMethodSecurityExpressionHandler) this.handler).setApplicationContext(applicationContext);
    }

    @Override
    public Object filter(Object filterTarget, Expression filterExpression, EvaluationContext ctx) {
        if (filterTarget instanceof Optional) {
            final List<?> optionalUnfilteredList = ((Optional<?>) filterTarget).stream()
                    .collect(Collectors.toList());

            final List<?> optionalFilteredList = (List<?>) this.handler.filter(optionalUnfilteredList, filterExpression, ctx);
            return optionalFilteredList.stream()
                    .findFirst();
        }
        return this.handler.filter(filterTarget, filterExpression, ctx);
    }

    // Implement other methods from MethodSecurityExpressionHandler as needed
    @Override
    public EvaluationContext createEvaluationContext(Object a, Object b) {
        return handler.createEvaluationContext(a, b);
    }

    @Override
    public boolean hasPermission(EvaluationContext a, Object b, Object c) {
        return handler.hasPermission(a, b, c);
    }

    @Override
    public boolean hasPermission(EvaluationContext a, Object b, Object c, Object d) {
        return handler.hasPermission(a, b, c, d);
    }
}