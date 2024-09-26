import javax.security.auth.DestroyFailedException;
import javax.security.auth.Destroyable;

public class SecurePassword implements Destroyable {
    private char[] password;
    private boolean destroyed = false;

    public SecurePassword(char[] password) {
        this.password = password.clone();
    }

    @Override
    public void destroy() throws DestroyFailedException {
        if (destroyed) {
            throw new IllegalStateException("Password has already been destroyed.");
        }

        for (int i = 0; i < password.length; i++) {
            password[i] = ' ';
        }

        destroyed = true;
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    // Additional methods
    public char[] getPassword() {
        if (destroyed) {
            throw new IllegalStateException("Password is destroyed and cannot be retrieved.");
        }
        return password.clone();
    }
}