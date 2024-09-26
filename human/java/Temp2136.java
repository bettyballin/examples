import java.util.Base64;

public class Temp2136 {
    public static void main(String[] args) {
        Pojo pojo = new Pojo("U29tZUVuY3J5cHRlZFN0cmluZw==");
        Log.e("ERROR", "AFTER: " + CryptUtils.decrypt(pojo.getName()));
    }
}

class Pojo {
    private String name;

    public Pojo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Log {
    public static void e(String tag, String message) {
        System.err.println(tag + ": " + message);
    }
}

class CryptUtils {
    public static String decrypt(String encrypted) {
        return new String(Base64.getDecoder().decode(encrypted));
    }
}