import org.springframework.core.MethodParameter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.bind.support.WebDataBinderFactory;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Define the CurrentUser annotation
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface CurrentUser {
}

// Define the MyUser class
class MyUser {
    private String username;
    
    public MyUser(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

// Define the CurrentUserMethodParameterAdapter class
@Component
public class CurrentUserMethodParameterAdapter implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(CurrentUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        if (parameter.hasParameterAnnotation(CurrentUser.class)) {
            return (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }
        return null;
    }
}

// Define the WebConfig class to register the argument resolver
@ControllerAdvice
public class WebConfig implements HandlerMethodArgumentResolver {
    private final CurrentUserMethodParameterAdapter currentUserMethodParameterAdapter;

    public WebConfig(CurrentUserMethodParameterAdapter currentUserMethodParameterAdapter) {
        this.currentUserMethodParameterAdapter = currentUserMethodParameterAdapter;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return currentUserMethodParameterAdapter.supportsParameter(parameter);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        return currentUserMethodParameterAdapter.resolveArgument(parameter, mavContainer, webRequest, binderFactory);
    }
}

// Define the WebMvcConfigurerAdapter configuration class
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addArgumentResolvers(java.util.List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new CurrentUserMethodParameterAdapter());
    }
}