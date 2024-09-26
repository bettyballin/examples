csharp
using System;
using System.Text;
using System.Linq;

class Program
{
    static void Main()
    {
        string oauth_consumer_secret = "your_secret_key_here";
        byte[] encodedSecret = Encoding.UTF8.GetBytes(oauth_consumer_secret);
        byte[] key1 = new byte[] { /* initialize your key1 here */ };
        var key2 = key1.Concat(encodedSecret).ToArray();
    }
}