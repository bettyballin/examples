import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class RecipeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private UserService userService;

    @Autowired
    private RecipeController recipeController;

    @Test
    public void testListRecipes() throws Exception {
        User user = new User();
        user.setUsername("testUser");

        List<Recipe> recipes = new ArrayList<>();
        Recipe recipe = new Recipe();
        recipes.add(recipe);

        when(userService.findByUsername(anyString())).thenReturn(user);
        when(recipeService.findAll()).thenReturn(recipes);

        mockMvc = MockMvcBuilders
                    .standaloneSetup(recipeController)
                    .apply(springSecurity())
                    .build();

        mockMvc.perform(get("/recipes").with(user("testUser")))
               .andExpect(status().isOk());
    }
}