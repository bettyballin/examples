csharp
using System;
using System.Security.Permissions;
using System.IO;

namespace MethodSecuritySpike
{
    class Program
    {

        static void Main(string[] args)
        {
            Console.WriteLine("Printing ini file from security enforced method:");
            var printer1 = new FileIOPermissionExceptionThrower();
            printer1.PrintIniFile();
            Console.WriteLine();
            Console.WriteLine("Bypassing security:");
            var printer2 = new InheritanceDemandExceptionThrower();
            printer2.PrintIniFile();
            Console.ReadLine();      
        }
    }

    public class FileIOPermissionExceptionThrower
    {
        [FileIOPermission(SecurityAction.Demand, Read = "ini.txt")]
        public void PrintIniFile()
        {
            Console.WriteLine(File.ReadAllText("ini.txt"));
        }
    }

    public class InheritanceDemandExceptionThrower : FileIOPermissionExceptionThrower
    {
        public new void PrintIniFile()
        {
            base.PrintIniFile();
        }
    }
}