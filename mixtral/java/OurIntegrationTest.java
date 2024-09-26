import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OurIntegrationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() throws Exception {
        RestAssuredMockMvc.webAppContextSetup(this.webApplicationContext);

        // Add filters if necessary
        // FilterChainProxy filterChain = (FilterChainProxy) webApplicationContext
        //         .getBean("springSecurityFilterChain");

        // MockMvcRequestSpecification requestSpec = new RequestSpecBuilder()
        //     .addFilters(filterChain.getFilters())
        //     .build();

        // Use the customized spec for requests
        // RestAssuredMockMvc.requestSpecification(requestSpec);
    }

    @Test
    public void our_test() {
        // Your test code here
    }
}