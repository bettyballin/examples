import com.macasaet.fernet.Key;
import com.macasaet.fernet.StringValidator;
import com.macasaet.fernet.Token;
import com.macasaet.fernet.Validator;

import java.time.Duration;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        String keyString = "j2v_wwTtEanOKF4-OqXtJ8ECi9UGOD72uGuJLJqZUuE=";
        String tokenString = "gAAAAABfEJkmA7qy6voW6-xZMz4wYqcies156jEBXbqkk585aerDwKRlQAuFOkSv94Ac503WSk222ayQMvPmweDp9IRakq3mBMrBY7zyRt9ou5luqpTXs8HDWvCjpJ0y66-hboULhyut";

        Key key = new Key(keyString);
        Token token = Token.fromString(tokenString);

        Validator<String> validator = new StringValidator() {
            public void validate(final String message) {
                // custom validation logic (if necessary)
            }
        };

        try {
            Instant now = Instant.now();
            Instant tokenTimestamp = Instant.parse("2020-07-16T18:15:02.456832100Z");
            Duration ttl = Duration.ofMinutes(5); // Adjust the TTL as per your requirement

            if (now.isAfter(tokenTimestamp.plus(ttl))) {
                throw new Exception("Token is expired");
            }

            String decryptedText = token.validateAndDecrypt(key, validator);
            System.out.println("Decrypted text: " + decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}