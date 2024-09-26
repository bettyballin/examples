#include <limits.h>
#include <stdlib.h>
#include <stdio.h>

int main() {
    char path[PATH_MAX];
    char resolved_path[PATH_MAX];

    printf("Enter a path: ");
    fgets(path, PATH_MAX, stdin);
    path[strcspn(path, "\n")] = 0; // remove newline character

    if (realpath(path, resolved_path) == NULL) {
        perror("realpath");
        return EXIT_FAILURE;
    }

    printf("Canonicalized absolute pathname: %s\n", resolved_path);

    return EXIT_SUCCESS;
}