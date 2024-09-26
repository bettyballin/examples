csharp
using System;
using System.IdentityModel.Tokens;
using System.Security.Cryptography;

public class CustomSecurityToken : SecurityToken
{
    public string Id { get; set; }
}

public class CustomSecurityTokenHandler : SecurityTokenHandler
{
    public override SecurityKeyIdentifierClause CreateSecurityTokenReference(SecurityToken token, bool attached)
    {
        if (token == null)
            throw new ArgumentNullException("token");

        return new LocalIdKeyIdentifierClause(token.Id);
    }
}

class Program
{
    static void Main(string[] args)
    {
        var token = new CustomSecurityToken { Id = Guid.NewGuid().ToString() };
        var handler = new CustomSecurityTokenHandler();
        var reference = handler.CreateSecurityTokenReference(token, false);
        Console.WriteLine(reference.Id);
    }
}