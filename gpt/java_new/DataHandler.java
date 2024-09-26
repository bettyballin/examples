import java.util.Arrays;

public class DataHandler {
    public static void main(String[] args) {
        char[] sensitiveData = {'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};

        // Process sensitive data

        // When done, explicitly overwrite the data
        Arrays.fill(sensitiveData, '\u0000');
    }
}