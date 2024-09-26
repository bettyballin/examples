csharp
using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void RetrieveKeys(string plain, string cipher)
    {
        var keyPairs = Enumerable.Range(0, 256).SelectMany(x => Enumerable.Range(0, 256).Select(y => (x, y))).ToHashSet();

        for (int i = 0; i < plain.Length; i++)
        {
            int a = plain[i];
            int e = cipher[i];
            var s = new HashSet<(int, int)>();

            for (int key = 0; key < 256; key++)
            {
                s.Add((key, (((e - (a ^ key)) % 256) ^ key)));
            }

            keyPairs.IntersectWith(s);
        }

        foreach (var kp in keyPairs)
        {
            Console.WriteLine($"KEY={kp.Item1}, KEY2={kp.Item2}");
        }
    }

    static void Main()
    {
        string plaintext = "Hello world, this is a test";
        string ciphertext = "b5>>?z'?,&>6~z&BA+zA+z9z&5+&";
        RetrieveKeys(plaintext, ciphertext);
    }
}