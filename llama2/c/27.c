#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/wait.h>

int main() {
    char *cmdline_args[3]; // array of command arguments
    char *env[] = {NULL}; // environment variables
    int pid, status;

    cmdline_args[0] = "/bin/bash";
    cmdline_args[1] = "-c";
    cmdline_args[2] = "\"/root/script.sh\" > /root/script1.sh";

    switch (pid = fork()) {
        case -1:
            perror("fork");
            return 1;
        case 0: // for execve
            status = execve(cmdline_args[0], cmdline_args, env);
            perror("execve");
            exit(status);
        default: // for parent
            waitpid(pid, &status, 0);
            if (WIFEXITED(status))
                printf("Child process exited with status %d\n", WEXITSTATUS(status));
            else
                printf("Child process did not exit normally\n");
            return 0;
    }
}