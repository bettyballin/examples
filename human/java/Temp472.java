import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.user.client.Window;

import java.util.List;
import java.util.Arrays;

public class Temp472 {
    public static void main(String[] args) {
        List<String> roles = Arrays.asList("role1", "role2"); // Example roles, replace with actual roles

        if (roles.contains("role1")) {
            GWT.runAsync(new RunAsyncCallback() {
                public void onFailure(Throwable caught) {
                    Window.alert("Code download failed");
                }

                public void onSuccess() {
                    // code here if the user has role1
                    System.out.println("User has role1");
                }
            });
        }
        if (roles.contains("role2")) {
            GWT.runAsync(new RunAsyncCallback() {
                public void onFailure(Throwable caught) {
                    Window.alert("Code download failed");
                }

                public void onSuccess() {
                    // code here if the user has role2
                    System.out.println("User has role2");
                }
            });
        }
        // and so on
    }
}