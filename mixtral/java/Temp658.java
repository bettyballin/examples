import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.Filter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootApplication
@AutoConfigureMockMvc
public class Temp658 {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private Filter springSecurityFilter;

    private MockMvc mockMvc;

    public static void main(String[] args) {
        SpringApplication.run(Temp658.class, args);
    }

    @Autowired
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .addFilters(springSecurityFilter)
                .build();

        // or if you want to add it only for specific URLs
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .defaultRequest(get("/").with(request -> {
                    request.setAttribute("javax.servlet.http.HttpServletRequest.FILTERED", true);
                    return request;
                }))
                .addFilters(springSecurityFilter)
                .build();
    }
}