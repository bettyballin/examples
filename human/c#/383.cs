csharp
using System;
using System.Linq;
using WebMatrix.WebData;
using YourDbContextNamespace; // Replace with your DbContext namespace

public class YourClassName
{
    public void YourMethodName()
    {
        var currentUserId = WebSecurity.CurrentUserId;
        using (var db = new YourDbContext()) // Replace with your DbContext class
        {
            var companyId = db.Companies
                              .Where(x => x.UserID == currentUserId)
                              .Select(x => x.CompanyID)
                              .Single();
        }
    }
}