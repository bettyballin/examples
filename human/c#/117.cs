Here is the C# code:

csharp
using System;
using System.Security.Cryptography;
using System.Text;
using System.Windows.Forms;

public class KeyGenerator
{
    public static void GenerateHexKey()
    {
        string result = Microsoft.VisualBasic.Interaction.InputBox("How many bits?", "Key Generator", "128");

        int len = 128;

        if (string.IsNullOrEmpty(result)) return;

        if (!int.TryParse(result, out len)) return;

        Cursor oldCursor = Cursor.Current;

        Cursor.Current = Cursors.WaitCursor;

        byte[] buff = new byte[len / 8];
        RNGCryptoServiceProvider rng = new RNGCryptoServiceProvider();

        rng.GetBytes(buff);

        StringBuilder sb = new StringBuilder((len / 8) * 2);
        foreach (byte b in buff)
        {
            sb.AppendFormat("{0:X2}", b);
        }

        // You will need to implement your own text insertion logic here.
        // The EnvDTE namespace is specific to Visual Studio and is not available in standard .NET.
        Console.WriteLine(sb.ToString());

        Cursor.Current = oldCursor;
    }
}