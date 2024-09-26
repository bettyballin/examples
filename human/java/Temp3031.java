public class Temp3031 {
    public static void main(String[] args) {
        boolean auth = true;  // Example value for authorization check
        int resourceSize = 10 * 1024 * 1024;  // Example resource size in bytes

        if (auth != false && resourceSize < 20 * 1024 * 1024) {
            System.out.println("Write allowed.");
        } else {
            System.out.println("Write not allowed.");
        }
    }
}