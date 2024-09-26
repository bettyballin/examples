import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.Intent;
import android.os.Bundle;

public class Temp402 extends Activity {
    private static final int REQUEST_CODE_START_ENCRYPTION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Launch the activity to activate encryption. May or may not return!
        Intent intent = new Intent(DevicePolicyManager.ACTION_START_ENCRYPTION);
        startActivityForResult(intent, REQUEST_CODE_START_ENCRYPTION);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_START_ENCRYPTION) {
            // Handle the result of the encryption activation
            if (resultCode == RESULT_OK) {
                // Encryption was successfully started
            } else {
                // Encryption was not started or failed
            }
        }
    }
}