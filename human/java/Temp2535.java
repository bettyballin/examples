public class Temp2535 {
    public static void main(String[] args) {
        System.setProperty("com.ibm.msg.client.commonservices.trace.outputName", "/tmp/x/y/z/mqjms_%PID%.trc");
        System.out.println("Property set: " + System.getProperty("com.ibm.msg.client.commonservices.trace.outputName"));
    }
}