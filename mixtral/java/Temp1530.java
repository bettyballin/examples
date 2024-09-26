class UserDetail {
    private String username;

    public UserDetail(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

public class Temp1530 {
    public static void main(String[] args) {
        UserDetail userDetail = new UserDetail("exampleUser");
        String currentUsername = userDetail.getUsername();
        System.out.println("Current Username: " + currentUsername);
    }
}