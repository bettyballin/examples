public class Temp1762 {
    public static void main(String[] args) {
        try {
            ProcessBuilder javacProcessBuilder = new ProcessBuilder("javac", "-cp", "./jBCrypt-0.4/src/", "RandTest.java");
            javacProcessBuilder.inheritIO();
            Process javacProcess = javacProcessBuilder.start();
            javacProcess.waitFor();
            
            ProcessBuilder javaProcessBuilder = new ProcessBuilder("java", "-cp", "./jBCrypt-0.4/src/:.", "RandTest");
            javaProcessBuilder.inheritIO();
            Process javaProcess = javaProcessBuilder.start();
            javaProcess.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}