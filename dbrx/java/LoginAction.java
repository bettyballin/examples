public class LoginAction {

    private String username;
    private boolean success;
    private String ipAddress;
    private String userAgent;

    // Getter and Setter for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter and Setter for success
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    // Getter and Setter for ipAddress
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    // Getter and Setter for userAgent
    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public static void main(String[] args) {
        // Example usage
        LoginAction login = new LoginAction();
        login.setUsername("user123");
        login.setSuccess(true);
        login.setIpAddress("192.168.1.1");
        login.setUserAgent("Mozilla/5.0");

        System.out.println("Username: " + login.getUsername());
        System.out.println("Login Success: " + login.isSuccess());
        System.out.println("IP Address: " + login.getIpAddress());
        System.out.println("User Agent: " + login.getUserAgent());
    }
}