import org.hamcrest.Matchers;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class Temp2685 {

    private static MockMvc mockMvc;
    private static WebApplicationContext webApplicationContext;

    public static void main(String[] args) throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        String content = "{\"key\":\"value\"}"; // Replace with actual JSON content
        MvcResult result = mockMvc.perform(post("/authorize")
                        .header(HttpHeaders.AUTHORIZATION, "Basic " + encodeEmailAndPassword("test1@app.com", "1111"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id_token", Matchers.notNullValue()))
                .andReturn();
    }

    private static String encodeEmailAndPassword(String email, String password) {
        String auth = email + ":" + password;
        return java.util.Base64.getEncoder().encodeToString(auth.getBytes());
    }
}