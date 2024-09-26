csharp
using System;
using System.Web.Security;

class Program
{
    static void Main()
    {
        string username = "JohnDoe";
        bool isPersistent = true;

        var authenticationTicket = new FormsAuthenticationTicket(
                             1, 
                             username, 
                             DateTime.Now, 
                             DateTime.Now.Add(FormsAuthentication.Timeout), 
                             isPersistent, 
                             "My Custom Data String"); //Limit to about 1200 bytes max

        string encryptedTicket = FormsAuthentication.Encrypt(authenticationTicket);
        Console.WriteLine("Encrypted Ticket: " + encryptedTicket);

        FormsAuthenticationTicket decryptedTicket = FormsAuthentication.Decrypt(encryptedTicket);
        Console.WriteLine("Decrypted Ticket: " + decryptedTicket.Name);
    }
}