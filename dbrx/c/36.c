#include <fcntl.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <sys/acl.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main() {
    int fd;
    acl_t acl;

    // Open/create directory with appropriate permissions.
    if ((fd = open("my_directory", O_DIRECTORY | O_CREAT, 0700)) == -1) {
        perror("open");
        return 1;
    }

    // Create ACL for the new file.
    acl = acl_init(3);
    acl_add_perm(acl, ACL_READ);
    acl_add_perm(acl, ACL_WRITE);

    // Set default permissions on directory so that newly created files inherit them.
    if (acl_set_file("my_directory", ACL_TYPE_DEFAULT, acl) == -1) {
        perror("acl_set_file");
        return 2;
    }

    // Create a new file with the desired security attributes.
    fd = openat(fd, "newfile.txt", O_CREAT | O_EXCL, S_IRUSR | S_IWUSR);
    if (fd == -1) {
        perror("openat");
        return 3;
    }
    
    close(fd);

    // Clean up ACL resources.
    acl_free(acl);

    return 0;
}