import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.core.Authentication;
import org.springframework.expression.EvaluationContext;
import org.springframework.stereotype.Service;
import org.aopalliance.intercept.MethodInvocation;

@Service
public class MySecurityExpressionHandler extends DefaultMethodSecurityExpressionHandler {

    @Override
    public EvaluationContext createEvaluationContextInternal(Authentication auth, MethodInvocation mi) {
        EvaluationContext evaluationContext = super.createEvaluationContextInternal(auth, mi);

        // Assuming SomeMethodInfoData and the way to compute value based on method info data are defined elsewhere
        SomeMethodInfoData methodInfoData = /* obtain SomeMethodInfoData from mi */;
        Object value = /* compute value based on methodInfoData */;

        evaluationContext.setVariable("someData", value);

        return evaluationContext;
    }
}