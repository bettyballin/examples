#include <stdio.h>
#include <unistd.h>

int main() {
    char *name[] = {"/bin/sh", NULL};
    execve(name[0], name, NULL);
    return 0;
}