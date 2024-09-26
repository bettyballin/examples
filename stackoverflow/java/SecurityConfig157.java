public class SecurityConfig157 {
    private String loginUrl;
    private String loginSuccessUrl;
    private int otherProperty;

    public SecurityConfig157() {
        this.loginUrl = "/login";
        this.loginSuccessUrl = "/success";
        this.otherProperty = 123;
    }

    // Getters and Setters
    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public String getLoginSuccessUrl() {
        return loginSuccessUrl;
    }

    public void setLoginSuccessUrl(String loginSuccessUrl) {
        this.loginSuccessUrl = loginSuccessUrl;
    }

    public int getOtherProperty() {
        return otherProperty;
    }

    public void setOtherProperty(int otherProperty) {
        this.otherProperty = otherProperty;
    }
}