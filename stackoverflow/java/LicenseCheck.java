import java.util.Calendar;

public class LicenseCheck {
    public static void main(String[] args) {
        Calendar expiry = Calendar.getInstance();
        expiry.set(2010, Calendar.JANUARY, 31, 0, 0); // Expire at 31 Jan 2010
        Calendar now = Calendar.getInstance();

        if (now.after(expiry)) {
            // Exit with proper expiry message
            System.out.println("The license has expired.");
        } else {
            // let the customer enjoy your software
            System.out.println("Enjoy the software.");
        }
    }
}