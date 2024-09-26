import org.springframework.web.servlet.config.annotation.WebMvcConfig2urer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import java.util.Arrays;

public class WebMvcConfig2 implements WebMvcConfig2urer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CorsInterceptor(Arrays.asList("http://myApplication.myDomain.net", "http://www.myApplication.myDomain.net")));
    }

    // ...

}