import javax.persistence.Embeddable;

@Embeddable
public class AccountCredentials {
    private String username;
    private String password;

    public AccountCredentials() {}

    public AccountCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

@Embeddable
public class AccountPermissions {
    private boolean canRead;
    private boolean canWrite;

    public AccountPermissions() {}

    public AccountPermissions(boolean canRead, boolean canWrite) {
        this.canRead = canRead;
        this.canWrite = canWrite;
    }

    // Getters and setters
    public boolean isCanRead() {
        return canRead;
    }

    public void setCanRead(boolean canRead) {
        this.canRead = canRead;
    }

    public boolean isCanWrite() {
        return canWrite;
    }

    public void setCanWrite(boolean canWrite) {
        this.canWrite = canWrite;
    }
}