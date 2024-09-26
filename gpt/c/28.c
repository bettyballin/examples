
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int execute_iptables_as_root(const char *command) {
    pid_t pid;
    int status;

    pid = fork();
    if (pid == -1) {
        // Handle fork failure
        return -1;
    }
    
    if (pid == 0
