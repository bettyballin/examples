import org.springframework.mock.web.MockServletContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example")
class AppConfig extends WebMvcConfigurerAdapter {
}

@Controller
class PersonController {
    @RequestMapping("/person")
    @ResponseBody
    public String getPerson() {
        return "John Doe";
    }
}

public class Temp1533 {
    public static void main(String[] args) {
        MockServletContext servletContext = new MockServletContext();
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AppConfig.class);
        context.setServletContext(servletContext);
        context.refresh();

        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup((WebApplicationContext) context)
                .addFilters(new CharacterEncodingFilter()).build();

        System.out.println("MockMvc setup complete");
    }
}