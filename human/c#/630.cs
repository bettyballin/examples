csharp
using System;
using System.IO;
using System.Windows.Forms;

public class frmMain : Form
{
    private Boolean FocusTreeview = false;
    private TreeView treeView1;
    private ListView listView1;

    public frmMain()
    {
        this.Size = new System.Drawing.Size(800, 600);

        treeView1 = new TreeView();
        treeView1.Location = new System.Drawing.Point(12, 12);
        treeView1.Size = new System.Drawing.Size(250, 500);
        treeView1.NodeMouseClick += new TreeNodeMouseClickEventHandler(treeView1_NodeMouseClick);
        this.Controls.Add(treeView1);

        listView1 = new ListView();
        listView1.Location = new System.Drawing.Point(300, 12);
        listView1.Size = new System.Drawing.Size(450, 500);
        listView1.SelectedIndexChanged += new EventHandler(listView1_SelectedIndexChanged);
        listView1.MouseUp += new MouseEventHandler(listView1_MouseUp);
        listView1.DoubleClick += new EventHandler(listView1_DoubleClick);
        this.Controls.Add(listView1);

        PopulateTreeView();
    }

    private void PopulateTreeView()
    {
        TreeNode rootNode;

        treeView1.Nodes.Clear();
        listView1.Items.Clear();

        DirectoryInfo info = new DirectoryInfo("C:\\"); // Pass the root folder here.

        // Add the root directory.
        if (info.Exists)
        {
            rootNode = new TreeNode(info.Name);
            rootNode.Tag = info;
            GetDirectories(info.GetDirectories(), rootNode);
            treeView1.Nodes.Add(rootNode);
            treeView1.Nodes[0].Expand();
            // This selects the root directory
            NodeSelect(rootNode);
        }
    }

    private void GetDirectories(DirectoryInfo[] subDirs, TreeNode nodeToAddTo)
    {
        // This will list all the directories and subdirectories
        TreeNode aNode;
        DirectoryInfo[] subSubDirs;
        foreach (DirectoryInfo subDir in subDirs)
        {
            aNode = new TreeNode(subDir.Name, 0, 0);
            aNode.Name = subDir.ToString();
            aNode.Tag = subDir;
            aNode.ImageKey = "Directory";
            subSubDirs = subDir.GetDirectories();
            if (subSubDirs.Length != 0)
            {
                GetDirectories(subSubDirs, aNode);
            }
            nodeToAddTo.Nodes.Add(aNode);
        }
    }

    private void NodeSelect(TreeNode newSelected)
    {
        //Load all the files and directorys in the selected node from the treeview
        listView1.Items.Clear();
        DirectoryInfo nodeDirInfo = (DirectoryInfo)newSelected.Tag;
        ListViewItem.ListViewSubItem[] subItems;
        ListViewItem item = null;

        foreach (DirectoryInfo dir in nodeDirInfo.GetDirectories())
        {
            item = new ListViewItem(dir.Name, 0);
            subItems = new ListViewItem.ListViewSubItem[]
              {new ListViewItem.ListViewSubItem(item, "Directory"), 
               new ListViewItem.ListViewSubItem(item, 
            dir.LastAccessTime.ToShortDateString())};
            item.SubItems.AddRange(subItems);
            listView1.Items.Add(item);
        }
        foreach (FileInfo file in nodeDirInfo.GetFiles())
        {
            item = new ListViewItem(file.Name, 1);
            subItems = new ListViewItem.ListViewSubItem[] { new ListViewItem.ListViewSubItem(item, "File"), new ListViewItem.ListViewSubItem(item, file.LastAccessTime.ToShortDateString()) };

            item.SubItems.AddRange(subItems);
            listView1.Items.Add(item);
        }

        listView1.AutoResizeColumns(ColumnHeaderAutoResizeStyle.HeaderSize);
    }

    void treeView1_NodeMouseClick(object sender, TreeNodeMouseClickEventArgs e)
    {
        TreeNode newSelected = e.Node;
        NodeSelect(newSelected);
    }

    private void listView1_SelectedIndexChanged(object sender, EventArgs e)
    {
        // When something is selected load it's contents to the listview if it is a directory
        if (listView1.SelectedItems.Count > 0)
        {
            var item = listView1.SelectedItems[0];

            // Don't do anything if it's just a file
            if (item.SubItems[1].Text == "File")
            {
                return;
            }

            TreeNode[] tns = treeView1.Nodes.Find(item.Text, true);
            if (tns.Length > 0)
            {
                treeView1.Focus();
                NodeSelect(tns[0]);
                treeView1.SelectedNode = tns[0];
                tns[0].Expand();
                FocusTreeview = true;
            }
        }
    }

    private void listView1_MouseUp(object sender, MouseEventArgs e)
    {
        // This needs to be done so the directory appears to stay selected in the treeview
        if (FocusTreeview == true)
        {
            treeView1.Focus();
            FocusTreeview = false;
        }
    }

    private void listView1_DoubleClick(object sender, EventArgs e)
    {
        // This will open the files that are double clicked on
        if (listView1.SelectedItems.Count > 0)
        {
            var item = listView1.SelectedItems[0];

            // Don't do anything for directories
            if (item.SubItems[1].Text == "Folder")
            {
                return;
            }

            // Open the selected file
            Process.Start(((DirectoryInfo)treeView1.SelectedNode.Tag).FullName + "\\" + item.Text);

        }
    }

    [STAThread]
    static void Main()
    {
        Application.EnableVisualStyles();
        Application.SetCompatibleTextRenderingDefault(false);
        Application.Run(new frmMain());
    }
}