import org.hamcrest.Matchers;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Other imports and class definition

public MvcResult authorize(MockMvc mockMvc, String content) throws Exception {
    return mockMvc.perform(post("/authorize")
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

private String encodeEmailAndPassword(String email, String password) {
    // Implementation of the encoding method
    return "";
}