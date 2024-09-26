csharp
using System;
using System.Collections.Generic;

public class OAuthAccountManager
{
    private Dictionary<string, Dictionary<string, int>> oauthAccounts = new Dictionary<string, Dictionary<string, int>>();
    private Dictionary<int, string> userNames = new Dictionary<int, string>();
    private int nextUserId = 1;

    public void CreateOrUpdateOAuthAccount(string provider, string providerUserId, string userName)
    {
        if (!oauthAccounts.TryGetValue(provider, out var providerAccounts))
        {
            providerAccounts = new Dictionary<string, int>();
            oauthAccounts[provider] = providerAccounts;
        }

        if (!providerAccounts.TryGetValue(providerUserId, out var userId))
        {
            userId = nextUserId++;
            providerAccounts[providerUserId] = userId;
            userNames[userId] = userName;
        }
        else
        {
            userNames[userId] = userName;
        }
    }

    public int GetUserIdFromOAuth(string provider, string providerUserId)
    {
        if (oauthAccounts.TryGetValue(provider, out var providerAccounts) &&
            providerAccounts.TryGetValue(providerUserId, out var userId))
        {
            return userId;
        }
        return -1;
    }

    public string GetUserNameFromId(int userId)
    {
        return userNames.TryGetValue(userId, out var userName) ? userName : null;
    }
}