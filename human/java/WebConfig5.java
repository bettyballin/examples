import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.core.MethodParameter;

import java.util.List;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public CurrentUserMethodArgumentResolver userMethodArgumentResolver() {
        return new CurrentUserMethodArgumentResolver() {
            @Override
            protected Object resolveName(String name, MethodParameter parameter, NativeWebRequest request) throws Exception {
                SecurityContext securityContext = SecurityContextHolder.getContext();
                CurrentUser annotation = parameter.getParameterAnnotation(CurrentUser.class);
                boolean anonymousUser = securityContext.getAuthentication() instanceof AnonymousAuthenticationToken;
                if (annotation.required() && anonymousUser) {
                    throw new BadCredentialsException("access is denied");
                }
                return super.resolveName(name, parameter, request);
            }
        };
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(userMethodArgumentResolver());
    }
}

// Assume the following classes/interfaces are defined elsewhere in your project
interface CurrentUserMethodArgumentResolver extends HandlerMethodArgumentResolver {
    Object resolveName(String name, MethodParameter parameter, NativeWebRequest request) throws Exception;
}

@interface CurrentUser {
    boolean required();
}