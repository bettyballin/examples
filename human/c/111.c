#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <errno.h>

#define R_OK 4
#define W_OK 2

int updatefile(char *file)
{
    int   fd = -1;

    if(-1 != (fd = open(file, O_RDWR)))
    {
         struct stat buf;

         if(0 == fstat(fd, &buf))
         {
             /* perform any necessary check on the file here */
             printf("File size: %d\n", (int)buf.st_size);

             /* do what ever else you need to do */

             /* write to the file here */
             char *str = "Hello, World!";
             write(fd, str, strlen(str));

             /* gain elevated permissions here */
             setuid(0);

             /* do privileged task */
             printf("Privileged task\n");

             /* drop back to normal permissions here */
             setuid(getuid());

             close(fd);
         }
         else
         {
             /* handle error stating the file */
             perror("fstat");
         }
    }
    else
    {
         /* handle error for not opening file */
         perror("open");
    }
    return 0;
}

int main(int argc, char *argv[])
{
    if (argc != 2) {
        printf("Usage: %s filename\n", argv[0]);
        return 1;
    }
    return updatefile(argv[1]);
}