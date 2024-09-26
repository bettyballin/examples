public class Temp579 {
    public static void main(String[] args) {
        CustomUsernamePasswordToken token = new CustomUsernamePasswordToken("username", "password", "attribute1Value");
        CustomUsernamePasswordToken ctoken = token;
        
        // Access your additional fields here
        String attribute1 = ctoken.getAttribute1();
        System.out.println("Attribute1: " + attribute1);
    }
}

class CustomUsernamePasswordToken {
    private String username;
    private String password;
    private String attribute1;

    public CustomUsernamePasswordToken(String username, String password, String attribute1) {
        this.username = username;
        this.password = password;
        this.attribute1 = attribute1;
    }

    public String getAttribute1() {
        return attribute1;
    }
}