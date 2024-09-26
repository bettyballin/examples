public class Temp2536 {
    public static void main(String[] args) {
        try {
            String[] command = {
                "java",
                "-Dcom.ibm.msg.client.commonservices.trace.status=ON",
                "-Dcom.ibm.msg.client.commonservices.trace.outputName=mqjms_%PID%.trc",
                "SomeJavaApp"
            };

            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.inheritIO();
            Process process = processBuilder.start();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}