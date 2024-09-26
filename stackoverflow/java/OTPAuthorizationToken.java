public class OTPAuthorizationToken extends AuthorizationToken {
    private String otp;

    public OTPAuthorizationToken(String username, String password, String otp) {
        super(username, password);
        this.otp = otp;
    }

    public String getOTP() {
        return otp;
    }
}

class AuthorizationToken {
    private String username;
    private String password;

    public AuthorizationToken(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Assuming getters and setters for username and password are here
}