import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

// Define the CustomAuthPrincipal annotation
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomAuthPrincipal {}

// Define the MyTransformedPrincipal class
class MyTransformedPrincipal {
    // Add fields and methods as necessary
    // Example:
    private String username;

    public MyTransformedPrincipal(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

// Define the MyAuthenticationPrincipalArgumentResolver class
public class MyAuthenticationPrincipalArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(CustomAuthPrincipal.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        if (parameter.hasParameterAnnotation(CustomAuthPrincipal.class)) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null && authentication.isAuthenticated()) {
                // Transform your principal object here
                return new MyTransformedPrincipal(authentication.getName());
            }
        }
        return null;
    }
}

// Define the WebMvcConfig class
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        MyAuthenticationPrincipalArgumentResolver resolver = new MyAuthenticationPrincipalArgumentResolver();
        argumentResolvers.add(resolver);
    }
}