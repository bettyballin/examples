public class ErrorInfo {

    private String errorMessage;

    public ErrorInfo(String error) {
        this.errorMessage = error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public static void main(String[] args) {
        ErrorInfo errorInfo = new ErrorInfo("Sample error message");
        System.out.println(errorInfo.getErrorMessage());
    }
}