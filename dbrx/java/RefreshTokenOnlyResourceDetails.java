public interface ResourceDetails {
    boolean isClientOnly();
    GrantType getGrantType();
}

public enum GrantType {
    REFRESH_TOKEN;
}

public class RefreshTokenOnlyResourceDetails implements ResourceDetails {
    private String refreshToken;

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Override
    public boolean isClientOnly() {
        return true;
    }

    @Override
    public GrantType getGrantType() {
        return GrantType.REFRESH_TOKEN;
    }

    public static void main(String[] args) {
        RefreshTokenOnlyResourceDetails details = new RefreshTokenOnlyResourceDetails();
        details.setRefreshToken("your_refresh_token_here");
        System.out.println("Is client only: " + details.isClientOnly());
        System.out.println("Grant type: " + details.getGrantType());
        System.out.println("Refresh token: " + details.getRefreshToken());
    }
}