import java.util.Arrays;

public class Temp1150 {
    public static void main(String[] args) {
        char[] password = getPassword();
        String strPassword = new String(password);
        Arrays.fill(password, '0');
        password = null;

        // Call to a library method expecting strings.
        thirdPartyLibraryMethod(strPassword);

        // Overwrite or zero-out any sensitive data stored as Strings within those libraries if possible.
        strPassword = null;
    }

    private static char[] getPassword() {
        // This method simulates password input. Replace this with actual password input logic.
        return "secret".toCharArray();
    }

    private static void thirdPartyLibraryMethod(String password) {
        // This method simulates a third-party library method call. Replace this with actual method logic.
        System.out.println("Password received by third-party library: " + password);
    }
}