csharp
using System;

public enum EncryptionAlgorithm
{
    Aes128,
    Aes256,
    // Add other algorithms as needed
}

public class Recipient
{
    public EncryptionAlgorithm[] EncryptionAlgorithms { get; set; }
}

class Program
{
    static void Main()
    {
        Recipient recipient = new Recipient();
        recipient.EncryptionAlgorithms = new EncryptionAlgorithm[] {
            EncryptionAlgorithm.Aes128
        };
    }
}