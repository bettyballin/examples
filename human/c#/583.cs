csharp
using Microsoft.AspNetCore.Identity;
using System;
using System.Collections.Generic;
using System.Threading.Tasks;

public class ApplicationUser : IdentityUser
{
}

public class ApplicationUserManager : UserManager<ApplicationUser>
{
    private readonly RoleManager<IdentityRole> _roleManager;

    public ApplicationUserManager(IUserStore<ApplicationUser> store, RoleManager<IdentityRole> roleManager)
        : base(store)
    {
        _roleManager = roleManager;
    }

    public async Task<IList<IdentityRole>> GetModelRolesAsync(string userId)
    {
        IList<string> roleNames = await base.GetRolesAsync(userId);

        var identityRoles = new List<IdentityRole>();
        foreach (var roleName in roleNames)
        {
            IdentityRole role = await _roleManager.FindByNameAsync(roleName);
            identityRoles.Add(role);
        }

        return identityRoles;
    }
}

public class Program
{
    public static async Task Main(string[] args)
    {
        var userStore = new UserStore<ApplicationUser>(new DbContext());
        var roleStore = new RoleStore<IdentityRole>(new DbContext());
        var roleManager = new RoleManager<IdentityRole>(roleStore, null, null, null, null);
        var userManager = new ApplicationUserManager(userStore, roleManager);

        var user = new ApplicationUser { Id = "1", UserName = "test" };
        await userManager.CreateAsync(user);
        await userManager.AddToRoleAsync(user, "Admin");

        var roles = await userManager.GetModelRolesAsync(user.Id);
        foreach (var role in roles)
        {
            Console.WriteLine(role.Name);
        }
    }
}

public class DbContext : IdentityDbContext<ApplicationUser>
{
    public DbContext(DbContextOptions<DbContext> options) : base(options) { }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
    {
        optionsBuilder.UseInMemoryDatabase(databaseName: "test");
    }
}