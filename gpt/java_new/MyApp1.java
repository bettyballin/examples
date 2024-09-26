import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class MyApp1 extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        
        // Initialize Firebase
        if (!FirebaseApp.getApps(this).isEmpty()) {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        }
    }
}

To use Firebase in an Android project, make sure to add the necessary dependencies to your `build.gradle` (Module: app) file:
gradle
dependencies {
    // Add the Firebase SDK for Google Analytics
    implementation 'com.google.firebase:firebase-analytics:xx.x.x'
    // Add the Firebase SDK for Firebase Auth
    implementation 'com.google.firebase:firebase-auth:xx.x.x'
    // Add the Firebase SDK for Firebase Realtime Database
    implementation 'com.google.firebase:firebase-database:xx.x.x'
}

// ADD THIS AT THE BOTTOM
apply plugin: 'com.google.gms.google-services'

Please replace `xx.x.x` with the latest versions of the Firebase libraries you need.

Remember to apply the Google Services plugin by adding the classpath in your project-level `build.gradle` file:
gradle
buildscript {
    dependencies {
        // Add this line
        classpath 'com.google.gms:google-services:x.x.x'
    }
}