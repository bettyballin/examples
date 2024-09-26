import java.util.ArrayList;
import java.util.List;

public class Temp1952 {
    public static void main(String[] args) {
        final List<AuthenticationProvider> providers = new ArrayList<>();
        providers.add(new AuthenticationProvider("AuthenticationProvider object values"));
    }
}

class AuthenticationProvider {
    private String value;

    public AuthenticationProvider(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "AuthenticationProvider{" +
                "value='" + value + '\'' +
                '}';
    }
}