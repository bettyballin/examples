csharp
using System;
using System.Security.Cryptography;
using System.Text;

public class Program
{
    public static void Main()
    {
        var mediakey = Encoding.UTF8.GetBytes("your_media_key");
        var salt = Encoding.UTF8.GetBytes("your_salt");

        using (var hkdf = new HkdfSha256())
        {
            var mediaKeyExtracted = hkdf.Extract(mediakey, null);
            var mediaKeyExpanded = hkdf.Expand(mediaKeyExtracted, 112, salt);

            Console.WriteLine(BitConverter.ToString(mediaKeyExtracted));
            Console.WriteLine(BitConverter.ToString(mediaKeyExpanded));
        }
    }
}

public class HkdfSha256 : IDisposable
{
    private readonly HMACSHA256 hmac;

    public HkdfSha256()
    {
        hmac = new HMACSHA256();
    }

    public byte[] Extract(byte[] ikm, byte[] salt)
    {
        if (salt == null)
        {
            salt = new byte[hmac.HashSize / 8];
        }

        hmac.Key = salt;
        return hmac.ComputeHash(ikm);
    }

    public byte[] Expand(byte[] prk, int outputLength, byte[] info)
    {
        var result = new byte[outputLength];
        var index = 0;

        for (var i = 1; i <= (outputLength + hmac.HashSize - 1) / hmac.HashSize; i++)
        {
            var buffer = new byte[info.Length + 1 + (i == 1 ? 0 : hmac.HashSize / 8)];
            info.CopyTo(buffer, 0);
            buffer[info.Length] = (byte)i;
            if (i > 1)
            {
                hmac.ComputeHash(prk).CopyTo(buffer, info.Length + 1);
            }

            hmac.Key = prk;
            var hash = hmac.ComputeHash(buffer);

            if (outputLength - index < hmac.HashSize / 8)
            {
                Array.Copy(hash, 0, result, index, outputLength - index);
                break;
            }

            hash.CopyTo(result, index);
            index += hmac.HashSize / 8;
        }

        return result;
    }

    public void Dispose()
    {
        hmac.Dispose();
    }
}