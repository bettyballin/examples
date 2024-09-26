csharp
using System;
using System.Diagnostics;
using System.Windows.MessageBox;
using System.IO;

public class Program
{
    public static bool RestartAsAdministrator(string filePath, string fileName, string errorCaption)
    {
        Process process = null;
        ProcessStartInfo processStartInfo = new ProcessStartInfo();
        processStartInfo.FileName = Path.Combine(filePath, fileName);

        if (Environment.OSVersion.Version.Major >= 5) 
            processStartInfo.Verb = "runas";

        processStartInfo.Arguments = "";
        processStartInfo.WindowStyle = ProcessWindowStyle.Normal;
        processStartInfo.UseShellExecute = true;

        try
        {
            process = Process.Start(processStartInfo);
        }

        catch (Exception)
        {
            MessageBox.Show("Couldn't start as admin.\nPlease try manually by Right Clicking on " + Path.GetFileNameWithoutExtension(fileName) + " and selecting \"Run as administrator\"",
                            errorCaption + " Error", MessageBoxButton.OK, MessageBoxImage.Error);

            return false;
        }

        finally
        {
            if (process != null)
                process.Dispose();
        }

        return true;
    }

    public static void Main()
    {
        RestartAsAdministrator(@"C:\Path\To\File", "MyFile.exe", "My Error Caption");
    }
}