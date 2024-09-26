import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import java.io.InputStream;

public class YourActivity extends AppCompatActivity {
    static final int IMAGE_CAPTURE_REQUEST_CODE = 1; // example request code

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMAGE_CAPTURE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Uri resultUri = null; // Initialize your URI here
                try {
                    InputStream inputStream = getContentResolver().openInputStream(resultUri);
                    // Process the InputStream as needed
                } catch (Exception e) {
                    // Handle the exception
                }
            }
        }
    }
}