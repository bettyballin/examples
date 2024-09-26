import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Component
class Temp29 {
    @Autowired
    private LocaleContextHolder localeContextHolder;

    public void doSomething() {
        Locale locale = localeContextHolder.getLocale();
        System.out.println(locale);
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Temp29 temp29 = context.getBean(Temp29.class);
        temp29.doSomething();
        context.close();
    }
}

class LocaleContextHolder {
    private Locale locale = Locale.getDefault();

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}

@Configuration
class AppConfig {
    @Bean
    public LocaleContextHolder localeContextHolder() {
        return new LocaleContextHolder();
    }

    @Bean
    public SessionLocaleResolver localeContextResolver() {
        SessionLocaleResolver resolver = new SessionLocaleResolver();
        resolver.setDefaultLocale(Locale.US);
        return resolver;
    }
}