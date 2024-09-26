import play.mvc.Controller;
import play.mvc.Result;
import play.filters.csrf.RequireCSRFCheck;
import play.filters.csrf.AddCSRFToken;
import play.filters.csrf.NoCSRF;

public class Temp231 extends Controller {
    public static void main(String[] args) {
        // Your main method code here
    }

    public Result canvas() {
        // Your code here
        return ok("Canvas Page");
    }

    @NoCSRF
    public Result facebookCanvasAction(){
        return ok("Facebook Canvas Page");
    }
}