import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

public class YourTestClass1 {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                                 .addFilter(new DelegatingFilterProxy("springSecurityFilterChain", context.getServletContext()))
                                 .build();
    }
}