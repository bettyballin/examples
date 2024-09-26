
#include <unistd.h>
#include <signal.h>
#include <stdio.h>

int safe_kill(pid_t pid, int sig) {
    if (pid <= 0) {
        fprintf(stderr, "Invalid PID: %d\n", pid);
        return -1;
    }

    return kill(pid, sig);
}

