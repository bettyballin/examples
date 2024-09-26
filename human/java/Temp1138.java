public class Temp1138 {

    public static void main(String[] args) {
        OTPAuthorizationToken token = new OTPAuthorizationToken("user", "pass", "123456");
        System.out.println("OTP: " + token.getOTP());
    }
}

class OTPAuthorizationToken extends AuthorizationToken {
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

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}