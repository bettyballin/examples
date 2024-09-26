csharp
using System;
using System.Security;
using System.ServiceModel;

class Program
{
    static void Main()
    {
        try
        {
            CustUserNamePasswordVal validator = new CustUserNamePasswordVal();
            validator.Validate("jack", "123456");
            Console.WriteLine("Validation successful");
        }
        catch (FaultException ex)
        {
            Console.WriteLine(ex.Message);
        }

        try
        {
            CustUserNamePasswordVal validator = new CustUserNamePasswordVal();
            validator.Validate("wrong", "wrong");
            Console.WriteLine("Validation successful");
        }
        catch (FaultException ex)
        {
            Console.WriteLine(ex.Message);
        }
    }
}

internal class CustUserNamePasswordVal : UserNamePasswordValidator
{
    public override void Validate(string userName, string password)
    {
        if (userName != "jack" || password != "123456")
        {
            throw new FaultException("Username/Password is not correct");
        }
    }
}