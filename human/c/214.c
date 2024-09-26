#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {
    char file[20];
    fgets(file, sizeof(file), stdin);
    file[strcspn(file, "\n")] = 0;
    char cmd[200];
    snprintf(cmd, sizeof(cmd), "touch %s", file);
    system(cmd);
    return 0;
}