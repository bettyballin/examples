import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class Main55 {
    public static void main(String[] args) {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser mFirebaseUser = mAuth.getCurrentUser();
        if (mFirebaseUser != null) {
            // User is signed in
        } else {
            // No user is signed in
            // Redirect to login or sign up
        }
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        // further code using database...
    }
}