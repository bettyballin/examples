import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.util.Objects;

@Aspect
@Order(0)
@Component
public class NoNullArgsAspect {

    @Before("(!execution(* *.getMetaClass(..))) && (@within(com.perfectcomputersolutions.pos.annotation.NoNullArgs) || @annotation(com.perfectcomputersolutions.pos.annotation.NoNullArgs))")
    public void requireNotNull(JoinPoint jp) {
        MethodSignature methodSignature = (MethodSignature) jp.getSignature();
        String[] parameterNames = methodSignature.getParameterNames();
        Object[] args = jp.getArgs();

        for (int i = 0; i < args.length; i++)
            Objects.requireNonNull(args[i], "Parameter " + parameterNames[i] + " must not be null");
    }
}