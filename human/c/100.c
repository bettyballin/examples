#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>

int main() {
    char* str = "hello world";
    int fd = open("test", O_WRONLY | O_CREAT, 0644);
    write(fd, str, strlen(str));
    close(fd);
    fd = open("test", O_WRONLY);
    ftruncate(fd, 11);
    close(fd);
    return 0;
}