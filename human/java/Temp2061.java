import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import javax.servlet.Filter;
import org.springframework.web.context.WebApplicationContext;

@Component
public class Temp2061 {

    @Autowired
    private WebApplicationContext context;
    
    @Autowired
    private Filter springSecurityFilterChain;

    private MockMvc mockMvc;

    public static void main(String[] args) {
        Temp2061 temp = new Temp2061();
        temp.setup();
    }

    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                                 .addFilters(springSecurityFilterChain)
                                 .build();
        // Add additional testing or setup code here if needed
    }
}