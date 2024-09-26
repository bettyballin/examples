csharp
using System;
using System.Security.Cryptography;
using System.Text;
using System.IO;

public class CredentialManager
{
    public static void WriteCredential(string applicationName, string userName, string password)
    {
        byte[] passwordBytes = Encoding.UTF8.GetBytes(password);
        byte[] protectedBytes = ProtectedData.Protect(passwordBytes, null, DataProtectionScope.CurrentUser);

        string path = Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.UserProfile), ".credentials", applicationName);
        Directory.CreateDirectory(Path.GetDirectoryName(path));

        using (FileStream stream = new FileStream(path, FileMode.Create))
        {
            using (StreamWriter writer = new StreamWriter(stream))
            {
                writer.WriteLine(userName);
                writer.WriteLine(Convert.ToBase64String(protectedBytes));
            }
        }
    }

    public static string ReadCredential(string applicationName)
    {
        string path = Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.UserProfile), ".credentials", applicationName);

        if (File.Exists(path))
        {
            using (FileStream stream = new FileStream(path, FileMode.Open))
            {
                using (StreamReader reader = new StreamReader(stream))
                {
                    reader.ReadLine();
                    string protectedString = reader.ReadLine();
                    byte[] protectedBytes = Convert.FromBase64String(protectedString);
                    byte[] passwordBytes = ProtectedData.Unprotect(protectedBytes, null, DataProtectionScope.CurrentUser);
                    return Encoding.UTF8.GetString(passwordBytes);
                }
            }
        }
        else
        {
            return null;
        }
    }
}

public class Program
{
    public static void Main()
    {
        CredentialManager.WriteCredential("ApplicationName", "Meziantou", "Passw0rd");
        Console.WriteLine(CredentialManager.ReadCredential("ApplicationName"));
    }
}