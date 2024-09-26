csharp
using System;
using System.Linq;
using System.Web;
using System.Web.Services;

public class CustomerService
{
    [WebGet]
    public IQueryable<Customers> Customers()
    {
        return this.CurrentDataSource.Customers.Where(x => x.IsDeleted == false);
    }
}

public class Customers
{
    public bool IsDeleted { get; set; }
}

public class DataSource
{
    public IQueryable<Customers> Customers { get; set; }
}

public class CurrentDataSource
{
    public DataSource Current { get; set; }
}

class Program
{
    static void Main(string[] args)
    {
        var customerService = new CustomerService();
        var customers = customerService.Customers();
        foreach (var customer in customers)
        {
            Console.WriteLine(customer.IsDeleted);
        }
    }
}