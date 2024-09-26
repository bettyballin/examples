public class CustomAccessDeniedException extends RuntimeException {
    private final String actionName;

    public CustomAccessDeniedException(String msg, HttpStatus statusCode, String actionName) {
        super(msg);
        this.actionName = actionName;
    }

    public String getActionName() {
        return actionName;
    }
}