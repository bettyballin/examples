csharp
using System;
using System.Collections.Generic;

public class Program
{
    public static void Main()
    {
        string xml = @"
<system.web>
    <authorization>
        <allow roles=""secure_role1""/> 
        <deny users=""*""/> 
    </authorization>
</system.web>";

        Console.WriteLine(xml);
    }
}