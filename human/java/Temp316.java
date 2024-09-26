import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;

public class Temp316 {

    public static void main(String[] args) {
        // Sample context for demonstration
        Context context = new MockContext();

        Temp316 temp = new Temp316();
        temp.execute(context);
    }

    public void execute(Context context) {
        AccountManager accountManager = AccountManager.get(context);
        Account[] accounts = accountManager.getAccounts();
        accountManager.getUserData(accounts[0], AccountManager.KEY_USERDATA);
    }

    // Mock Context class for demonstration purposes
    static class MockContext extends Context {
        // Implement necessary methods here
    }
}