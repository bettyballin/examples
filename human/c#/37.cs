csharp
using System;
using System.Security;
using System.Security.Permissions;

// BaseClass namespace and IniPrinterBase class definition
namespace BaseClass
{
    public class IniPrinterBase
    {
        [SecurityPermission(SecurityAction.Demand, Unrestricted = true)]
        public virtual void PrintIniFile()
        {
            ProtectedPrint();
        }

        protected void ProtectedPrint()
        {
            Console.WriteLine("Printing ini file...");
        }
    }
}

// DerivedClasses namespace and derived classes
[assembly: RegistryPermission(SecurityAction.RequestRefuse, Unrestricted = true)]
namespace DerivedClasses
{
    public class FileIOPermissionExceptionThrower : IniPrinterBase
    {
        public override void PrintIniFile()
        {
            base.PrintIniFile();
        }
    }

    public class InheritanceDemandExceptionThrower : IniPrinterBase
    {
        public override void PrintIniFile()
        {
            ProtectedPrint();
        }
    }

    public class Program
    {
        public static void Main(string[] args)
        {
            var fileIOPermissionExceptionThrower = new FileIOPermissionExceptionThrower();
            fileIOPermissionExceptionThrower.PrintIniFile();

            var inheritanceDemandExceptionThrower = new InheritanceDemandExceptionThrower();
            inheritanceDemandExceptionThrower.PrintIniFile();
        }
    }
}