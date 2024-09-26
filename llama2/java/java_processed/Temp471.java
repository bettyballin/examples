import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.security.Principal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import yourpackage.Recipe;
import yourpackage.RecipeService;
import yourpackage.User;
import yourpackage.UserService;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class Temp471 {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @MockBean
    private RecipeService recipeService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void listRecipes() throws Exception {
        // Given
        User user = new User();
        user.setUsername("john");
        user.setPassword("password");

        Principal principal = new UsernamePasswordAuthenticationToken(user, "password");

        // When
        MvcResult result = mvc.perform(get("/recipes").principal(principal))
                .andExpect(status().isOk())
                .andReturn();

        // Then
        List<Recipe> recipes = (List<Recipe>) result.getModelAndView().getModel().get("recipes");
        assertEquals(2, recipes.size());
    }
}