import org.apache.commons.lang3.ArrayUtils;
import java.util.Arrays;

public class SecureString {
    private char[] value;

    public SecureString(char[] value) {
        this.value = ArrayUtils.clone(value);
    }

    @Override
    protected void finalize() throws Throwable {
        clear();
        super.finalize();
    }

    public void clear() {
        if (value != null) {
            Arrays.fill(value, '\u0000');
        }
    }

    public char[] getValue() {
        return ArrayUtils.clone(value);
    }

    public static void main(String[] args) {
        char[] password = {'s', 'e', 'c', 'r', 'e', 't'};
        SecureString secureString = new SecureString(password);
        System.out.println("SecureString created with value: " + Arrays.toString(secureString.getValue()));
        secureString.clear();
        System.out.println("SecureString after clear: " + Arrays.toString(secureString.getValue()));
    }
}