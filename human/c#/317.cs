csharp
using Microsoft.Win32;

class Program
{
    static void Main()
    {
        string keyName = @"SOFTWARE\Microsoft\Windows\CurrentVersion\Internet Settings\Zones";
        using (RegistryKey key = Registry.CurrentUser.OpenSubKey(keyName))
        {
            if (key != null)
            {
                foreach (string zone in key.GetSubKeyNames())
                {
                    Console.WriteLine(zone);
                }
            }
        }
    }
}