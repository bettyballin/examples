import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Temp1456 {
    private static FirebaseAuth auth = FirebaseAuth.getInstance();

    public static void main(String[] args) {
        FirebaseUser currentUser = auth.getCurrentUser();
        String customId = "your_custom_id";
        String mUsername = "your_username"; // Replace with your actual username

        if (currentUser != null) {
            DatabaseReference ref = FirebaseDatabase
                    .getInstance()
                    .getReference("users")
                    .child(currentUser.getUid());

            Map<String, Object> userData = new HashMap<>();
            userData.put("name", mUsername);
            userData.put("customId", customId);

            ref.setValue(userData)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            // Data saved successfully
                            System.out.println("Data saved successfully");
                        } else {
                            displayError(task.getException().getMessage());
                        }
                    });
        } else {
            System.out.println("No authenticated user.");
        }
    }

    private static void displayError(String errorMessage) {
        System.err.println("Error: " + errorMessage);
    }
}