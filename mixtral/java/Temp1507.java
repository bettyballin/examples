import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class Temp1507 {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    public static void main(String[] args) {
        Temp1507 temp = new Temp1507();
        temp.setup();
    }

    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        // ...
    }
}