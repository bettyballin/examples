csharp
using System;
using System.Security;
using System.Security.Permissions;

[SecurityCritical]
public class SomeCriticalClass
{
    [SecurityCritical]
    public void Do()
    {
    }
}

[SecuritySafeCritical]
public sealed class SomeClass
{
    [SecuritySafeCritical]
    public void SomeMethod()
    {
        SomeCriticalClass critical = new SomeCriticalClass();

        // No more FieldAccessException!
        Action action = () => critical.Do();
        action();
    }
}

class Program
{
    static void Main(string[] args)
    {
        new SomeClass().SomeMethod();
    }
}