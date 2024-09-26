import com.sun.crypto.provider.SunJCE;

public class Temp549 {
    public static void main(String[] args) {
        SunJCE jce = new SunJCE();
        System.out.println("SunJCE provider instantiated: " + jce.getName());
    }
}