import java.security.MessageDigest;
import java.math.BigInteger;

public class Main31 {
    public static void main(String[] args) throws Exception {
        String producedKey = "36248441610316046373940723150439573936645456312032028064365240345591632292456385336418395841257359594423512887912569551847749513145040862559588574541468845827085159018247962009639778000068069176753753861222140233559881791396088762185913485540314156993368037042615619321223426679365899278177180176354";

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] messageDigest = md.digest(producedKey.getBytes());
        BigInteger no = new BigInteger(1, messageDigest);
        String hashtext = no.toString(16);
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        System.out.println(hashtext);
    }
}