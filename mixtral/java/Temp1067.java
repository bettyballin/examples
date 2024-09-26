import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class Temp1067 extends Activity {
    private static final int IMAGE_CAPTURE_REQUEST_CODE = 1;
    private Uri resultUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Your initialization code here
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMAGE_CAPTURE_REQUEST_CODE && resultCode == RESULT_OK) {
            resultUri = data.getData();
            getContentResolver().takePersistableUriPermission(resultUri,
                    Intent.FLAG_GRANT_READ_URI_PERMISSION |
                            Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        }
    }

    public static void main(String[] args) {
        // The main method is not typically used in Android applications.
    }
}