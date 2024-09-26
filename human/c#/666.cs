csharp
using System;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        RSAParameters parameters = new RSAParameters();
        parameters.Modulus = Convert.FromBase64String("your_modulus_here");
        parameters.Exponent = Convert.FromBase64String("your_exponent_here");
        parameters.D = Convert.FromBase64String("your_d_here");
        parameters.P = Convert.FromBase64String("your_p_here");
        parameters.Q = Convert.FromBase64String("your_q_here");
        parameters.DP = Convert.FromBase64String("your_dp_here");
        parameters.DQ = Convert.FromBase64String("your_dq_here");
        parameters.InverseQ = Convert.FromBase64String("your_inverseq_here");

        RSACryptoServiceProvider rsa = new RSACryptoServiceProvider();
        rsa.ImportParameters(parameters);
    }
}