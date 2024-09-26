csharp
using System;
using System.Reflection;
using System.Security.Cryptography;

namespace _51915147
{
    class Program
    {
        static void Main(string[] args)
        {
            var cryptoProvider = new TripleDESCryptoServiceProvider();
            cryptoProvider.Key = new byte[24] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24 };
            cryptoProvider.IV = new byte[8] { 1, 2, 3, 4, 5, 6, 7, 8 };
            var weakEncryptor = cryptoProvider.CreateWeakEncryptor();
            Console.WriteLine(weakEncryptor.GetType().Name);
        }
    }

    public static class TripleDESCryptoServiceProviderExtensions
    {
        public static ICryptoTransform CreateWeakEncryptor(this TripleDESCryptoServiceProvider cryptoProvider, byte[] key, byte[] iv)
        {
            MethodInfo mi = cryptoProvider.GetType().GetMethod("_NewEncryptor", BindingFlags.NonPublic | BindingFlags.Instance);
            object[] Par = { key, cryptoProvider.Mode, iv, cryptoProvider.FeedbackSize, 1 };
            var trans = mi.Invoke(cryptoProvider, Par) as ICryptoTransform;
            return trans;
        }

        public static ICryptoTransform CreateWeakEncryptor(this TripleDESCryptoServiceProvider cryptoProvider)
        {
            return CreateWeakEncryptor(cryptoProvider, cryptoProvider.Key, cryptoProvider.IV);
        }
    }
}