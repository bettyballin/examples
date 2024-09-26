#include <stdio.h>
#include <limits.h>
#include <string.h>

int is_file_in_dir(const char *base, const char *path) {
    // Allocate memory for the resolved absolute path
    char real[PATH_MAX];

    if (realpath(path, real)) {
        size_t base_len = strlen(base);

        return strncmp(real, base, base_len) == 0 &&
               // Check that there's a '/' after the directory name
               (base_len == strlen(real) || real[base_len] == '/');
    }

    perror("Error resolving path");

    return -1;
}

int main() {
    const char *dir = "/path/to/your/directory";

    if (is_file_in_dir(dir, "./relative/path") == 1)
        printf("File is inside the directory\n");

    else if(is_file_in_dir(dir, "./relative/path") == -1)
        printf("Error occurred\n");
    else
        printf("File is not inside the directory\n");

    return 0;
}