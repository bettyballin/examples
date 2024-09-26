import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jwt.SignedJWT;

import java.text.ParseException;

public class Temp2260 {
    public static void main(String[] args) {
        String jws = "ey...QO+/vXk="; // Your JWT

        try {
            // Parse the compact JWS
            SignedJWT signedJWT = SignedJWT.parse(jws);

            // Extract and print out all claim values
            signedJWT.getJWTClaimsSet()
                     .getClaims()
                     .forEach((key, value) -> System.out.println(key + ": " + value));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}