import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Temp637 {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Temp637.class);
        context.refresh();
        Temp637 temp637 = context.getBean(Temp637.class);
        temp637.setupMockMvc();
    }

    @Autowired
    public void setWebApplicationContext(WebApplicationContext webApplicationContext) {
        this.webApplicationContext = webApplicationContext;
    }

    public void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
            .addFilters(new DelegatingFilterProxy("springSecurityFilterChain", webApplicationContext))
            .build();
        System.out.println("MockMvc setup completed.");
    }
}