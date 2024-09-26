import java.util.Base64;

public class PasswordCodecHandler {
    Base64.Encoder encoder = null;
    Base64.Decoder decoder = null;

    public PasswordCodecHandler() {
        encoder = Base64.getEncoder();
        decoder = Base64.getDecoder();
    }

    public String encode(String password) {
        byte[] temp;
        String encodedPassword = null;
        temp = encoder.encode(password.getBytes());
        encodedPassword = new String(temp);
        return encodedPassword;
    }

    public String decode(byte[] encodedPassword) {
        byte[] temp;
        String decodedPassword;
        temp = decoder.decode(encodedPassword);
        decodedPassword = new String(temp);
        return decodedPassword;
    }

    public static void main(String[] args) {
        PasswordCodecHandler passwordCodecHandler = new PasswordCodecHandler();
        String s1 = passwordCodecHandler.encode("password");
        System.out.println(s1);

        String s2 = passwordCodecHandler.encode("admin");
        System.out.println(s2);

        String s3 = passwordCodecHandler.encode("administrator");
        System.out.println(s3);

        String s4 = passwordCodecHandler.encode("123456");
        System.out.println(s4);
    }
}