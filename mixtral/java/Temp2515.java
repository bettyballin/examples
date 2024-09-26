import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

public class Temp2515 {

    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    public static void main(String[] args) throws Exception {
        Temp2515 temp = new Temp2515();
        temp.setup();

        MvcResult addMvcResult = temp.mockMvc.perform(post("/habit/friend/addById")
                .with(SecurityMockMvcRequestPostProcessors.httpBasic("Joey", "passwordEncoder"))
        ).andReturn();

        System.out.println("Result: " + addMvcResult.getResponse().getStatus());
    }
}