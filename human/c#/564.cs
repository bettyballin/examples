csharp
using System;

public class FinancialAccount
{
    public int Id { get; set; }
    // Add other properties as needed
}

public interface IFinancialAccountRepository
{
    FinancialAccount GetById(int accountId);
}

public class FinancialAccountRepository : IFinancialAccountRepository
{
    public FinancialAccount GetById(int accountId)
    {
        // Implement logic to retrieve financial account details from database or data source
        // For demonstration purposes, a dummy account is returned
        return new FinancialAccount { Id = accountId };
    }
}

public class FinancialAccountService
{
    private readonly IFinancialAccountRepository _financialAccountRepository;

    public FinancialAccountService(IFinancialAccountRepository financialAccountRepository)
    {
        _financialAccountRepository = financialAccountRepository;
    }

    public FinancialAccount GetFinancialAccountDetails(int accountId)
    {
        return _financialAccountRepository.GetById(accountId);
    }
}

class Program
{
    static void Main(string[] args)
    {
        var financialAccountRepository = new FinancialAccountRepository();
        var financialAccountService = new FinancialAccountService(financialAccountRepository);
        var financialAccount = financialAccountService.GetFinancialAccountDetails(1);
        Console.WriteLine($"Financial Account Id: {financialAccount.Id}");
    }
}