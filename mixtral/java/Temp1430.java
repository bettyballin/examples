import java.util.ArrayList;
import java.util.List;

public class Temp1430 {

    public static void main(String[] args) {
        getAjaxRequestTargetListeners().add(new SessionTimeoutAjaxCallDecorator());
    }

    public static List<AjaxCallDecorator> getAjaxRequestTargetListeners() {
        return new ArrayList<>();
    }

    static class SessionTimeoutAjaxCallDecorator extends AjaxCallDecorator {
        // Implementation of the decorator
    }

    static class AjaxCallDecorator {
        // Implementation of the base class
    }
}