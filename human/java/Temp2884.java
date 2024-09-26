public class Temp2884 {
    public static void main(String[] args) {
        setUserAuthenticationValidityDurationSeconds(10);
    }

    public static void setUserAuthenticationValidityDurationSeconds(int duration) {
        if (duration > 0) {
            System.out.println("User authentication validity duration set to " + duration + " seconds.");
        } else {
            System.out.println("Invalid duration. Please provide a positive integer.");
        }
    }
}