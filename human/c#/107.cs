csharp
using System;
using System.ComponentModel;

public class MyControl
{
    public MyControl()
    {
        License license = LicenseManager.Validate(typeof(MyControl), this);
    }
}

class Program
{
    static void Main()
    {
        MyControl control = new MyControl();
    }
}