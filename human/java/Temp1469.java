import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@SpringBootApplication
@AutoConfigureMockMvc
public class Temp1469 {
    
    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MockMvc mockMvc;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Temp1469.class, args);
        Temp1469 app = context.getBean(Temp1469.class);
        app.setup();
    }

    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }
}