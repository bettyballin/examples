public class Temp2607 {
    public static void main(String[] args) {
        String profilePattern = "myprofile.%resource%.%role%";
        boolean toUpperCase = true;

        String resource = "server";
        String role = "admin";

        String result = profilePattern
                .replace("%resource%", resource)
                .replace("%role%", role);

        if (toUpperCase) {
            result = result.toUpperCase();
        }

        System.out.println(result);
    }
}