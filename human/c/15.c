#include <stdio.h>
#include <stdlib.h>

int main() {
    FILE *fp = popen("./vulnerable", "w");
    if (fp == NULL) {
        perror("popen");
        return EXIT_FAILURE;
    }

    // write stuff to fp -- it goes to vulnerable's stdin
    fprintf(fp, "Hello, vulnerable!\n");

    int exitcode = pclose(fp);
    if (exitcode == -1) {
        perror("pclose");
        return EXIT_FAILURE;
    }

    printf("vulnerable exited with code %d\n", WEXITSTATUS(exitcode));
    return EXIT_SUCCESS;
}