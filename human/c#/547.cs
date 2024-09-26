csharp
using System;
using Firebase.Auth;
using System.Text;

public class FirebaseUserManager
{
    private FirebaseApp app;

    public FirebaseUserManager(string firebaseUrl)
    {
        app = FirebaseApp.Create(new AppOptions
        {
            Credential = GoogleCredential.FromFile("path/to/serviceAccountKey.json"),
            ProjectId = "your-project-id",
        });
    }

    public async void CreateUser(string email, string password)
    {
        try
        {
            var user = await FirebaseAuth.DefaultInstance.CreateUserAsync(email, password);
            Console.WriteLine($"Successfully created user account with uid: {user.Uid}");

            var ref = FirebaseDatabase.DefaultInstance.GetReference(base64Encode(email));
            await ref.SetValueAsync(new { uid = user.Uid });

            Login(email, password);
        }
        catch (FirebaseException ex)
        {
            Console.WriteLine(ex.Message);
        }
    }

    public async void Login(string email, string password)
    {
        try
        {
            await FirebaseAuth.DefaultInstance.SignInWithEmailAndPasswordAsync(email, password);
        }
        catch (FirebaseException ex)
        {
            Console.WriteLine(ex.Message);
        }
    }

    private string base64Encode(string str)
    {
        byte[] bytes = Encoding.UTF8.GetBytes(str);
        return Convert.ToBase64String(bytes);
    }
}