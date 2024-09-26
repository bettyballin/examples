import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
@Aspect
public class FruitTypeValidator {

    private final Set<String> VALID_FRUIT_TYPES = new HashSet<>(Arrays.asList("apple", "banana", "cherry"));

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void requestMapping() {}

    @Before("requestMapping()")
    public void validateFruitType(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        RequestMapping annotation = signature.getMethod().getAnnotation(RequestMapping.class);
        if (annotation != null && Arrays.stream(annotation.value()).anyMatch(path -> path.contains("/{type}"))) {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String type = request.getParameter("type");
            if (type != null && !VALID_FRUIT_TYPES.contains(type)) {
                throw new IllegalArgumentException("Invalid fruit type: " + type);
            }
        }
    }
}