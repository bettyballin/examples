Here is the C# equivalent of the provided C code:

csharp
using System;
using System.IO;
using System.Text;
using System.Security.Cryptography;

public class Program
{
    public static void Main()
    {
        string nz = "sqprMX0n4y1gmmgpTt6pHb870k5U0MIuXixidD+S8foQf5Bb" +
                    "FS44kth2uWDKzXOXqiONxIPHPb+84XdxrRi2O7bvLysztgrF" +
                    "eU8oNDMeuIwJOKVQzKoJ1vGqjBKiA9w48oQKxvO+Ck3GmObW" +
                    "67LFNcrt50sEco2/OMmrpiH3W8hRx55TcR1flCJduU0/6jA7" +
                    "Yct9ZfhOw5wBq6o5IwiT8Mi1R6LVq9sTzSNAWHC/bFcEONkt" +
                    "z6NgUKbFKtt+mTfFGToiwPB1L4TecGyTIweH84nl8jVAngcM" +
                    "vvFP415Eg1kd9PJbRqrIESM5AU1YcsapWV3bsqEGVS2y+r5N" +
                    "4yzXPCYRCRyFWJSnNVlax+gtDFTNz3m9UT8m2E7elGe5hPhR" +
                    "6nN3votzBNvTeQ4Lwc5JDIvnWUg7aOdVIXnHQbBqEQke79BX" +
                    "xIv8tzVPczGkFqFExkmPPQQv8zJvBKkIYc+BFJtkylBiZfQX" +
                    "0590NS3L1y31VSeXn8Ncx2/ceJfUXsMWJ3sQ+dk51MKBJ2LL" +
                    "oyJq8IgloBLnXWvlYZ+tkzRVTExFR277V3Jr17DeTOMQGEg5" +
                    "HqRkbDDVGPTl2RvC2S2BTe7+r9xNzyAZMieVjZLZgb6icE6u" +
                    "SJFcu4qqJ1khQUjW7taymqW8Ao3oEiCUJKvRpZcJPMN+JtMn" +
                    "ji+2we17ytk=";

        string ez = "AQAB";

        try
        {
            byte[] nBytes = Convert.FromBase64String(nz);
            byte[] eBytes = Convert.FromBase64String(ez);

            using (var rsa = RSA.Create())
            {
                rsa.ImportParameters(new RSAParameters
                {
                    Modulus = nBytes,
                    Exponent = eBytes
                });

                Console.WriteLine(rsa.ToString());
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine("Failed to parse and validate RSA key");
            Console.WriteLine(ex.Message);
        }
    }
}

Note that this C# code uses the built-in `System.Security.Cryptography` namespace to handle RSA operations, and does not require the use of the OpenSSL library.