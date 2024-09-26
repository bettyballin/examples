import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.context.annotation.Import;

@SpringJUnitConfig
@ContextConfiguration(classes = {PeopleGQLApi.class, PersonService.class})
@Import(SecurityConfigImpl.class)
public class PeopleGQLApiSecurityTest {

    @Autowired
    private PeopleGQLApi peopleGQLApi;

    // ...
}