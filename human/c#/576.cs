csharp
using System;
using Microsoft.Owin.Security.OAuth;

public class OAuthProvider : OAuthAuthorizationServerProvider
{
    public override Task ValidateClientAuthentication(OAuthValidateClientAuthenticationContext context)
    {
        string clientId;
        string clientSecret;
        context.TryGetBasicCredentials(out clientId, out clientSecret);

        if (context.ClientId == null)
        {
            context.SetError("invalid_clientId", "client_Id is not set");
            return Task.FromResult<object>(null);
        }

        var client = // retrieve your client from database or any other storage mechanism

        if (client == null || client.ClientId != clientId || client.ClientSecret != clientSecret)
        {
            context.SetError("invalid_clientId", "Invalid client_id or client_secret");
            return Task.FromResult<object>(null);
        }

        context.Validated();
        return Task.FromResult<object>(null);
    }
}