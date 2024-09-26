import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class Temp1829 {

    private MockMvc mockMvc;
    private RecipeController recipeController = new RecipeController(); // Assuming you have a RecipeController class

    public static void main(String[] args) {
        Temp1829 temp1829 = new Temp1829();
        temp1829.setup();
        try {
            temp1829.testListRecipes();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setup() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(recipeController)
                .defaultRequest(get("/").principal(new UsernamePasswordAuthenticationToken("username", "password"))).build();
    }

    @Test
    public void testListRecipes() throws Exception {
        mockMvc.perform(
                get("/recipes")
                        .with(user("username").roles("USER")))
                .andExpect(status().isOk());
    }
}

class RecipeController {
    // Implement the controller methods here
}