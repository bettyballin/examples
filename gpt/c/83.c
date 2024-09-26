
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/wait.h>

int foo(const char *cmdline) {
    pid_t pid;
    int status, ret = 0;
    char *env[] = { NULL }; // Assuming you have an environment prepared

    // No need to split the string yourself; let the shell handle it.
    char *cmdline_args[] = { "bash", "-c", cmdline, NULL };

    switch (pid = fork()) {
    case -1:
        ret = -1;
        break; // Need to break here to not fall through to the next case
    case 0: // for execve
        execve("/bin/bash", cmdline_args, env);
        perror
