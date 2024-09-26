csharp
using System;
using System.Text;

public class CustomEncoder
{
    private static readonly byte[] undefCodepoints = new byte[] { 0x81, 0x8d, 0x8f, 0x90, 0x9d };

    public static byte[] CustomEncode(string ciphertextB64)
    {
        byte[] cipherbytes = Convert.FromBase64String(ciphertextB64);
        string ciphertext = Encoding.UTF8.GetString(cipherbytes);
        byte[][] result = new byte[ciphertext.Length][];

        for (int i = 0; i < ciphertext.Length; i++)
        {
            char c = ciphertext[i];
            byte charByte = (byte)c;

            if (Array.IndexOf(undefCodepoints, charByte) != -1)
            {
                result[i] = new byte[] { charByte };
            }
            else
            {
                result[i] = Encoding.GetEncoding("Windows-1252").GetBytes(new char[] { c });
            }
        }

        byte[] finalResult = new byte[0];
        foreach (byte[] bytes in result)
        {
            byte[] temp = new byte[finalResult.Length + bytes.Length];
            finalResult.CopyTo(temp, 0);
            bytes.CopyTo(temp, finalResult.Length);
            finalResult = temp;
        }

        return finalResult;
    }
}