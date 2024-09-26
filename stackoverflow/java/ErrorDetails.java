public class ErrorDetails {
    private String custom_error;
    private String custom_error_description;

    public ErrorDetails(String custom_error, String custom_error_description) {
        this.custom_error = custom_error;
        this.custom_error_description = custom_error_description;
    }

    public String getCustom_error() {
        return custom_error;
    }

    public void setCustom_error(String custom_error) {
        this.custom_error = custom_error;
    }

    public String getCustom_error_description() {
        return custom_error_description;
    }

    public void setCustom_error_description(String custom_error_description) {
        this.custom_error_description = custom_error_description;
    }

    public static void main(String[] args) {
        ErrorDetails errorDetails = new ErrorDetails("invalid_grant", "Bad credentials");
        System.out.println("Error: " + errorDetails.getCustom_error());
        System.out.println("Description: " + errorDetails.getCustom_error_description());
    }
}