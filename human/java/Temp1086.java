public class Temp1086 {
    private static final String LOGTAG = "Temp1086";
    private static Logger logger = new Logger();

    public static void main(String[] args) {
        Temp1086 temp = new Temp1086();
        temp.shutdown();
    }

    public void shutdown() {
        if (logger.logDebug()) {
            logger.logDebug(LOGTAG, "Queuing shutdown message ...");
        }
        queueMessage(new BaseMessage(true));
    }

    private void queueMessage(BaseMessage message) {
        // Implementation of queueMessage
        System.out.println("Message queued: " + message);
    }

    // Dummy Logger class
    static class Logger {
        public boolean logDebug() {
            return true;
        }

        public void logDebug(String tag, String message) {
            System.out.println(tag + ": " + message);
        }
    }

    // Dummy BaseMessage class
    static class BaseMessage {
        private boolean shutdown;

        public BaseMessage(boolean shutdown) {
            this.shutdown = shutdown;
        }

        @Override
        public String toString() {
            return "BaseMessage{shutdown=" + shutdown + "}";
        }
    }
}