import lombok.*;

@Data
@RequiredArgsConstructor
public class LoginResult {

    @NonNull
    private String jwt;

    public static void main(String[] args) {
        LoginResult loginResult = new LoginResult("exampleJWT");
        System.out.println(loginResult);
    }
}