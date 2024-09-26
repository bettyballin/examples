csharp
using System;
using System.Formats.Asn1;
using System.Numerics;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        string dhParamsPem = "-----BEGIN DH PARAMETERS-----\n" +
                             "MIIBCAKCAQEAy8Dbv8prpJ/0kKhlGeJYozo2t60EG8L0561g13R29LvMR5hyvGZlGJpmn65+A4xHXInJYiPuKzrKfDNSHCoL2SiSjPjRb\n" +
                             "/jYZLZeJ4bhLd2vIzUZ3KgzTtq2aKU5xKc2U2ZV87udvXgGZp8zWv7r+4X3kn5JlmXK5+PwLj0vV3jTGPZxf+5JgZtClVvF+8n\n" +
                             "2JkU5uUwZTzYRzjWuX9YTWZVmsL8jLQgGJLWJ+YuhU8zvmLgixZgOQzKgQzKgQzKgQzKAaUzVtjY2N6QzKgQzKgQzKgQzKAQ\n" +
                             "-----END DH PARAMETERS-----";

        PemFields pemFields = PemEncoding.Find(dhParamsPem);
        byte[] derData = Convert.FromBase64String(dhParamsPem.Substring(pemFields.Base64Data));
        AsnReader asn1Seq = new AsnReader(derData, AsnEncodingRules.DER).ReadSequence();
        BigInteger p = asn1Seq.ReadInteger();
        BigInteger g = asn1Seq.ReadInteger();

        Console.WriteLine("p: " + p);
        Console.WriteLine("g: " + g);
    }
}