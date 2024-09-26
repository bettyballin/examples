import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.annotation.MethodParameter;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final MyTransformedPrincipalArgumentResolver myTransformedPrincipalArgumentResolver;

    public WebConfig(MyTransformedPrincipalArgumentResolver myTransformedPrincipalArgumentResolver) {
        this.myTransformedPrincipalArgumentResolver = myTransformedPrincipalArgumentResolver;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(myTransformedPrincipalArgumentResolver);
    }
}

class MyTransformedPrincipalArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // Add your logic here
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, 
                                  ModelAndViewContainer mavContainer, 
                                  NativeWebRequest webRequest, 
                                  WebDataBinderFactory binderFactory) throws Exception {
        // Add your logic here
        return null;
    }
}