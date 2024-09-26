csharp
using System;
using System.Web.Security;

class Program
{
    static void Main()
    {
        string encryptedTicket = "your_encrypted_ticket_here";
        string expectedUsername = "your_expected_username_here";
        string UserDataDelimiter = "|";

        FormsAuthenticationTicket formsTicket = FormsAuthentication.Decrypt(encryptedTicket);

        string[] userData = formsTicket.UserData.Split(new string[] { UserDataDelimiter }, StringSplitOptions.None);

        if (formsTicket.Name == expectedUsername)
        {
            Console.WriteLine("Ticket is valid.");
        }
        else
        {
            Console.WriteLine("Ticket is not valid.");
        }
    }
}