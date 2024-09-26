public class Temp299 {
    public static void main(String[] args) {
        String[][] users = {
            {"username", "role"},
            {"adam", "customer"},
            {"admin", "admin"}
        };

        for (String[] user : users) {
            System.out.printf("| %-8s | %-62s |%n", user[0], user[1]);
        }
    }
}