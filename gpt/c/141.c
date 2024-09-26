sharp
using System;
using System.IO;
using System.Security.Cryptography;

public static byte[] EncryptAesCbcNoPadding(byte[] plainText, byte[] key)
{
    // Check arguments.
    if (plainText == null || plainText.Length <= 0)
        throw new ArgumentNullException("plainText");
    if (key == null || key.Length <= 0)
        throw new ArgumentNullException("key");

    //
