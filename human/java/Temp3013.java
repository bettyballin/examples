import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Temp3013 {
    public static void main(String[] args) {
        try {
            // Execute the az login command
            Process loginProcess = Runtime.getRuntime().exec("az login");
            loginProcess.waitFor();
            printProcessOutput(loginProcess);

            // Execute the az account set command
            String subscriptionId = "<your subscription id>";
            Process accountSetProcess = Runtime.getRuntime().exec("az account set --subscription " + subscriptionId);
            accountSetProcess.waitFor();
            printProcessOutput(accountSetProcess);

            // Execute the az ad sp create-for-rbac command
            Process createSpProcess = Runtime.getRuntime().exec("az ad sp create-for-rbac -n \"mysample\" --role Contributor");
            createSpProcess.waitFor();
            printProcessOutput(createSpProcess);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void printProcessOutput(Process process) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}