csharp
using Microsoft.AspNetCore.Authentication;
using Microsoft.AspNetCore.Identity;

public class AuthenticationManager
{
    public void SignIn(AuthenticationProperties properties, IdentityUser user)
    {
        // Your implementation here
    }
}

public class Program
{
    public static void Main()
    {
        bool rememberMe = true; // replace with your value
        IdentityUser userIdentity = new IdentityUser(); // replace with your value

        AuthenticationManager authenticationManager = new AuthenticationManager();
        authenticationManager.SignIn(new AuthenticationProperties { IsPersistent = rememberMe }, userIdentity);
    }
}