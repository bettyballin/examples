csharp
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Security;

public class SecurityKey { }

public class MyClass
{
    public virtual ReadOnlyCollection<SecurityKey> SecurityKeys
    {
        get { return new List<SecurityKey>().AsReadOnly(); }
    }
}

public class MyDerivedClass : MyClass
{
    public override ReadOnlyCollection<SecurityKey> SecurityKeys
    {
        get { return new List<SecurityKey>().AsReadOnly(); }
    }
}

class Program
{
    static void Main(string[] args)
    {
        MyDerivedClass myDerivedClass = new MyDerivedClass();
        ReadOnlyCollection<SecurityKey> securityKeys = myDerivedClass.SecurityKeys;
    }
}