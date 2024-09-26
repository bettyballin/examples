csharp
using System;
using System.Security;

public class Program
{
    public static void Main()
    {
        var orderTracker = new OrderTracker();
        var message = new Message();

        if (orderTracker.PrimarySignatureDone)
        {
            throw TraceUtility.ThrowHelperError(new MessageSecurityException(SR.GetString(SR.SignatureConfirmationsOccursAfterPrimarySignature)), message);
        }
    }
}

public class OrderTracker
{
    public bool PrimarySignatureDone { get; set; }
}

public class Message
{
}

public class MessageSecurityException : Exception
{
    public MessageSecurityException(string message) : base(message) { }
}

public static class SR
{
    public static string GetString(string key)
    {
        return key;
    }

    public static string SignatureConfirmationsOccursAfterPrimarySignature = "SignatureConfirmationsOccursAfterPrimarySignature";
}

public static class TraceUtility
{
    public static Exception ThrowHelperError(Exception exception, object message)
    {
        return exception;
    }
}