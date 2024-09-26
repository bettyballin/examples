import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

public class WebConfig implements WebMvcConfigurer {

   @Override
   public void addInterceptors(InterceptorRegistry registry) {
       LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
       localeInterceptor.setParamName("lang");
       registry.addInterceptor(localeInterceptor);
   }
}