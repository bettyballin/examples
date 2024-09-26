#include <linux/security.h>
#include <linux/fs.h>

static int my_lsm_file_open(struct file *file, const struct cred *cred)
{
    // Check if the user has permission to access this file or not.
    int ret = 0;

    // Get the inode and dentry from the file structure
    struct inode *inode = file_inode(file);
    struct dentry *dentry = file->f_path.dentry;

    // Perform permission check
    ret = inode_permission(inode, MAY_OPEN | MAY_READ | MAY_WRITE);

    if (ret == 0) {
        // Permission granted
        return 0;
    }

    // Permission denied
    return -EACCES;
}