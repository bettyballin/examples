#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

int main()
{
    char *name[2];

    name[0] = "/bin/sh";
    name[1] = NULL;

    // Create a new process using fork
    pid_t pid = fork();

    if (pid == 0) {
        // Child process execute the shell
        execve(name[0], name, NULL);
    } else if (pid > 0) {
        // Parent process wait for child to finish
        wait(NULL);
    } else {
        perror("fork");
        return 1;
    }

    return 0;
}