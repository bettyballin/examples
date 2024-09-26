
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>
#include <unistd.h>

int main() {
    const char *fileName = "/tmp/myfile";
    mode_t old_umask;

    // Get the current umask
    old_umask = umask
