csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        string ciphertextB64 = "amDDjAsQJjEzw7nFvSpcIgHFksO/xb3CoF7Cv+KAsMKN4oCZNeKAulxaHwghwo1ExaEQKcOrGMO9Iw4Rw4sncsOLxb3Di8OKwqs0AgdFwo1CB8Oy4oCTPkrDlSbDkTDDtB3Cj2PDocW4AcKxM0bigJnDgsOsw6scw47DlQHCuEEnwqxZwqnDp8KdDBNzw7JKw70aw5/DtcK2FHzigJNJwq1kBsKyw57CpMOiCkPigJQnw5nCgVUcw5bCtl9j4oCcG8OGw5Yiw4zCv1bDrzhBMREIwr1yKMOTT8OMw68OVsOKeGxxwq3Dv0Nkw4vDgcO4wqYCw7DDi8OEFsKjEcOjwrdzw5RUdU/CqwBZw6rDvcKsw67DvE5lwqvDhMKvw5HDiwBy4oC6NsO+w5vigLDDjcOGMHElHA7CjULDnsKtUuKAoH0LUxclPV3FuMO6aWtVAuKAnlcFwr/CsDbCqQEAwr1JMcW+w692w6XCrgbDt8ObZDnDgcOqF8KmwrrCucK9a8Kt4oCdZMOpHiPDigfDhcWSNMOmw7zDhcOPAMOlSzXDs2XDlMKoBcOLdcOMw5PDjeKAusKxw7U94oCgY8Oww6XDrnLigJQjcsO7wq8vy5wJMcK4cuKAoMO/MsO/4oCwJcOdXMK0fWxND8uGbiRnBMW4Kw==";
        byte[] cipherbytes = Convert.FromBase64String(ciphertextB64);
        byte[] key = new byte[] { 0x12, 0x34, 0x56, 0x78, 0x9A, 0xBC, 0xDE, 0xF0, 0x12, 0x34, 0x56, 0x78, 0x9A, 0xBC, 0xDE, 0xF0, 0x12, 0x34, 0x56, 0x78, 0x9A, 0xBC, 0xDE, 0xF0, 0x12, 0x34, 0x56, 0x78, 0x9A, 0xBC, 0xDE, 0xF0 };
        byte[] iv1 = new byte[] { 0x02, 0x13, 0x24, 0x35, 0x46, 0x57, 0x68, 0x79, 0x8A, 0x9B, 0xAC, 0xBD, 0xCE, 0xDF, 0xE0, 0xF1 };

        using (var aes = Aes.Create())
        {
            aes.Key = key;
            aes.IV = iv1;
            aes.Mode = CipherMode.CBC;
            aes.Padding = PaddingMode.None;

            using (var decryptor = aes.CreateDecryptor())
            {
                byte[] decrypted = decryptor.TransformFinalBlock(cipherbytes, 0, cipherbytes.Length);
                byte[] decryptedUnpad = Unpad(decrypted, 16);
                Console.WriteLine(Encoding.UTF8.GetString(decryptedUnpad));
            }
        }
    }

    static byte[] Unpad(byte[] data, int blockSize)
    {
        int padLength = data[data.Length - 1];
        return data.Take(data.Length - padLength).ToArray();
    }
}