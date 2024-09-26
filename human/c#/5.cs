csharp
using System;
using System.Collections.Generic;
using System.DirectoryServices;
using System.Windows.Forms;

public class Program
{
    public static List<DirectoryEntry> MembersOfGroup(string groupName)
    {
        List<DirectoryEntry> members = new List<DirectoryEntry>();
        try
        {
            using (DirectoryEntry search = new DirectoryEntry("WinNT://./" + groupName + ",group"))
            {
                foreach (object member in (IEnumerable)search.Invoke("Members"))
                {
                    DirectoryEntry memberEntry = new DirectoryEntry(member);
                    members.Add(memberEntry);
                }
            }
        }
        catch (Exception ex)
        {
            MessageBox.Show(ex.ToString());
        }
        return members;
    }

    [STAThread]
    static void Main()
    {
        string groupName = "YourGroupNameHere";
        List<DirectoryEntry> members = MembersOfGroup(groupName);
        foreach (DirectoryEntry member in members)
        {
            Console.WriteLine(member.Name);
        }
    }
}