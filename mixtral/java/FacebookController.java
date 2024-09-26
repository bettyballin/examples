import play.filters.csrf.NoCSRF;
import play.mvc.*;

public class FacebookController extends Controller {

    @NoCSRF
    public Result canvas() {
        // Your code here
        return ok("CSRF protection is disabled for this action.");
    }

    public static void main(String[] args) {
        FacebookController controller = new FacebookController();
        Result result = controller.canvas();
        System.out.println(result);
    }
}