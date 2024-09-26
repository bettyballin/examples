import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Temp344 {
    public static void main(String[] args) {
        try {
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setDatabaseUrl("https://myfirebase.firebaseio.com")
                    .setServiceAccount(new FileInputStream("/path/to/your-service-account.json"))
                    .build();

            FirebaseApp app = FirebaseApp.initializeApp(options);

            // Get a reference to the database
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference("server");

            ref.setValueAsync("Hello World!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}