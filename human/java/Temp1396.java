import java.util.Locale;

public class Temp1396 {
    private boolean ignorePasswordCase = true;

    public static void main(String[] args) {
        Temp1396 temp = new Temp1396();
        System.out.println(temp.isPasswordValid("encodedPassword", "rawPassword", "salt"));
    }

    public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
        String pass1 = encPass + "";

        // Strict delimiters is false because pass2 never persisted anywhere
        // and we want to avoid unnecessary exceptions as a result (the
        // authentication will fail as the encodePassword never allows them)
        String pass2 = mergePasswordAndSalt(rawPass, salt, false);

        if (ignorePasswordCase) {
            // Note: per String javadoc to get correct results for Locale insensitive, use English
            pass1 = pass1.toLowerCase(Locale.ENGLISH);
            pass2 = pass2.toLowerCase(Locale.ENGLISH);
        }
        return PasswordEncoderUtils.equals(pass1, pass2);
    }

    private String mergePasswordAndSalt(String password, Object salt, boolean strict) {
        if (password == null) {
            password = "";
        }

        if (strict && (salt != null)) {
            if ((salt.toString().lastIndexOf("{") != -1) || (salt.toString().lastIndexOf("}") != -1)) {
                throw new IllegalArgumentException("Cannot use { or } in salt.toString()");
            }
        }

        if ((salt == null) || "".equals(salt)) {
            return password;
        } else {
            return password + "{" + salt.toString() + "}";
        }
    }

    static class PasswordEncoderUtils {
        static boolean equals(String pass1, String pass2) {
            if (pass1 == null) {
                return false;
            }
            return pass1.equals(pass2);
        }
    }
}