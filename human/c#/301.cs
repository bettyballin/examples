csharp
using System;

public class AuthenticationResult
{
  public bool AreCredentialsValid { get; set; }
  public bool IsAccountLocked { get; set; }
  public bool RequiresPasswordChange { get; set; }
}

class Program
{
  static void Main()
  {
    AuthenticationResult result = new AuthenticationResult();
    result.AreCredentialsValid = true;
    result.IsAccountLocked = false;
    result.RequiresPasswordChange = false;

    Console.WriteLine("Are Credentials Valid: " + result.AreCredentialsValid);
    Console.WriteLine("Is Account Locked: " + result.IsAccountLocked);
    Console.WriteLine("Requires Password Change: " + result.RequiresPasswordChange);
  }
}