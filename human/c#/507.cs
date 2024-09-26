csharp
using System;
using System.Text;
using Windows.Security.Cryptography;
using Windows.Security.Cryptography.Core;

class Program
{
    static void Main()
    {
        byte[] encodedDataAsBytes = { 0x12, 0x34, 0x56, 0x78 }; // Replace with your encoded data

        String strAsymmetricAlgName = SymmetricAlgorithmNames.DesEcbPkcs7;
        SymmetricKeyAlgorithmProvider objAlgProv = SymmetricKeyAlgorithmProvider.OpenAlgorithm(strAsymmetricAlgName);

        CryptographicKey keyPair = objAlgProv.CreateSymmetricKey(CryptographicBuffer.ConvertStringToBinary("key", BinaryStringEncoding.Utf8));
        IBuffer str = CryptographicBuffer.CreateFromByteArray(encodedDataAsBytes);
        IBuffer buf = CryptographicEngine.Decrypt(keyPair, str, null);
        byte[] arr = buf.ToArray();
        string returnValue = System.Text.Encoding.UTF8.GetString(arr, 0, arr.Length);

        Console.WriteLine(returnValue);
    }
}