public class Temp2746 {
    public static void main(String[] args) {
        String command = "dsquery * \"DC=ah1,DC=ad,DC=megacorp,DC=com\" -filter \"(&(objectClass=group)(member=CN=Bloggs\\, Joe \\28SUPERHERO AGSC\\29,OU=Users,OU=Client,DC=ah1,DC=ad,DC=megacorp,DC=com))\"";
        try {
            Process process = Runtime.getRuntime().exec(command);
            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}