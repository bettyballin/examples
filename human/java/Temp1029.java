import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1029 extends WebSecurityConfigurerAdapter {
    private AuthenticationManagerBuilder authenticationBuilder;

    public static void main(String[] args) {
        // Just an example main method to make the class executable
        System.out.println("Temp1029 class executed!");
    }

    /**
     * Override this method to expose the {@link AuthenticationManager} from
     * {@link #configure(AuthenticationManagerBuilder)} to be exposed as
     * a Bean. For example:
     *
     * &lt;pre&gt;
     * &amp;#064;Bean(name name="myAuthenticationManager")
     * &amp;#064;Override
     * public AuthenticationManager authenticationManagerBean() throws Exception {
     *     return super.authenticationManagerBean();
     * }
     * &lt;/pre&gt;
     *
     * @return the {@link AuthenticationManager}
     * @throws Exception
     */
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}