public class LogSanitizer {
    public static String sanitizeLogEntry(String logEntry) {
        if (logEntry == null) {
            return null;
        }
        return logEntry.replaceAll("[\
\\r\\t]", "_");
    }
}