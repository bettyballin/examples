import java.util.Calendar;

public class Temp46 {
    public static void main(String[] args) {
        Calendar expiry = Calendar.getInstance();
        expiry.set(2010, 1, 31, 0, 0); // Expire at 31 Jan 2010
        Calendar now = Calendar.getInstance();
        // If you don't trust client's clock, fetch time from some reliable time server
        if (now.after(expiry)) {
            // Exit with proper expiry message
            System.out.println("The software has expired.");
        } else {
            // let the customer enjoy your software
            System.out.println("The software is active.");
        }
    }
}