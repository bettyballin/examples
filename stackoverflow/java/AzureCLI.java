// Java doesn't support Azure CLI commands directly.
// You would need to run these commands in a shell or use Azure SDK for Java.

// However, if you really want to execute these commands from Java, you could do something like this:

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AzureCLI {

    public static void main(String[] args) {
        try {
            Process process = Runtime.getRuntime().exec("az login");
            process.waitFor();
            process = Runtime.getRuntime().exec("az account set --subscription \"<your subscription id>\"");
            process.waitFor();
            process = Runtime.getRuntime().exec("az ad sp create-for-rbac -n \"mysample\" --role Contributor");
            process.waitFor();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}