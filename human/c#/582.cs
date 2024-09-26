csharp
using System;
using System.Collections.Generic;
using System.Threading.Tasks;

public class RoleService<TKey>
{
    public async Task<IList<string>> GetRolesAsync(TKey userId)
    {
        // implementation here
        await Task.Delay(100); // simulate async operation
        return new List<string> { "Admin", "Moderator" };
    }
}

class Program
{
    static async Task Main(string[] args)
    {
        var roleService = new RoleService<int>();
        var roles = await roleService.GetRolesAsync(1);
        foreach (var role in roles)
        {
            Console.WriteLine(role);
        }
    }
}