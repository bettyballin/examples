csharp
using System;
using System.Linq;
using System.Linq.Expressions;

public class Customer
{
    public bool IsDeleted { get; set; }
}

public class QueryInterceptorAttribute : Attribute
{
    public string EntitySetName { get; set; }

    public QueryInterceptorAttribute(string entitySetName)
    {
        EntitySetName = entitySetName;
    }
}

public class QueryInterceptor
{
    [QueryInterceptor("Customers")]
    public Expression<Func<Customer, bool>> ActiveCustomers()
    {
        return cust => cust.IsDeleted == false;
    }
}

class Program
{
    static void Main()
    {
        var interceptor = new QueryInterceptor();
        var customers = new[] { new Customer { IsDeleted = true }, new Customer { IsDeleted = false } };
        var activeCustomers = customers.AsQueryable().Where(interceptor.ActiveCustomers());
        foreach (var customer in activeCustomers)
        {
            Console.WriteLine(customer.IsDeleted);
        }
    }
}