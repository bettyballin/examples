public class Temp611 {
    public static void main(String[] args) {
        String userDetails = "exampleUser"; // Assuming some user details for demonstration

        if (userDetails != null) {
            option(userDetails);
        } else {
            none();
        }
    }

    public static void option(String userDetails) {
        System.out.println("Option called with userDetails: " + userDetails);
    }

    public static void none() {
        System.out.println("None called");
    }
}