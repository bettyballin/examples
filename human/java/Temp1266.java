import java.util.Date;

public class Temp1266 {
    private int id;
    private String username;
    private String password;
    private int failedAttempts;
    private Date lastFailed;
    private Date lastLogin;

    public static void main(String[] args) {
        Temp1266 temp = new Temp1266();
        temp.id = 1;
        temp.username = "user";
        temp.password = "pass";
        temp.failedAttempts = 0;
        temp.lastFailed = new Date();
        temp.lastLogin = new Date();

        System.out.println("ID: " + temp.id);
        System.out.println("Username: " + temp.username);
        System.out.println("Password: " + temp.password);
        System.out.println("Failed Attempts: " + temp.failedAttempts);
        System.out.println("Last Failed: " + temp.lastFailed);
        System.out.println("Last Login: " + temp.lastLogin);
    }
}