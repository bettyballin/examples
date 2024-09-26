// The provided code snippet is already compilable, assuming that the Lombok library is correctly set up in the project.
// However, if you want a version without Lombok, here is the refactored version:

public class LoginResult {
    private final String jwt;

    public LoginResult(String jwt) {
        if (jwt == null) {
            throw new NullPointerException("jwt is marked non-null but is null");
        }
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoginResult)) return false;

        LoginResult that = (LoginResult) o;

        return getJwt() != null ? getJwt().equals(that.getJwt()) : that.getJwt() == null;
    }

    @Override
    public int hashCode() {
        return getJwt() != null ? getJwt().hashCode() : 0;
    }
}