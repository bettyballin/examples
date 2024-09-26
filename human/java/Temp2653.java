import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class Temp2653 {
    private MockMvc mvc;

    public Temp2653(WebApplicationContext context) {
        this.mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    public void performTest() throws Exception {
        String jsonNode = "{ \"key\": \"value\" }"; // Replace with actual JSON content
        mvc.perform(MockMvcRequestBuilders.post("/admin/createUser")
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonNode))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    public static void main(String[] args) throws Exception {
        // Assuming there is a Spring context initialization here
        // WebApplicationContext context = ...;
        // Temp2653 temp = new Temp2653(context);
        // temp.performTest();
    }
}