csharp
using System;
using System.Security.Cryptography;
using System.Text;
using Microsoft.IdentityModel.Tokens;

class Program
{
    static void Main()
    {
        InMemorySymmetricSecurityKey signingKey = new InMemorySymmetricSecurityKey(Encoding.UTF8.GetBytes("secretsigningkey"));
    }
}