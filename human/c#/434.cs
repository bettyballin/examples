csharp
using System;
using Microsoft.Exchange.WebServices.Data;

class Program
{
    static void Main(string[] args)
    {
        ExchangeService exchangeService = new ExchangeService(ExchangeVersion.Exchange2013_SP1);
        exchangeService.Url = new Uri("https://outlook.office365.com/EWS/Exchange.asmx");
    }
}