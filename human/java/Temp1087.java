public class Temp1087 {

    public static void main(String[] args) {
        Temp1087 temp = new Temp1087();
        temp.c();
    }

    public void c() {
        if (logDebug()) {
            logDebug("MsgRouter", "Queuing shutdown message ...");
        }
        a(new A(true));
    }

    public boolean logDebug() {
        // Placeholder for actual debug logging condition
        return true;
    }

    public void logDebug(String tag, String message) {
        // Placeholder for actual logging implementation
        System.out.println(tag + ": " + message);
    }

    public void a(A a) {
        // Placeholder for method implementation
        System.out.println("Method a called with parameter: " + a);
    }

    class A {
        private boolean flag;

        public A(boolean flag) {
            this.flag = flag;
        }

        @Override
        public String toString() {
            return "A{flag=" + flag + "}";
        }
    }
}