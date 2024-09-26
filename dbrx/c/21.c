#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <limits.h>

int check_file_in_dir(const char *file_path, const char *dir_path) {
    // Get real paths for both input arguments
    char resolved_file[PATH_MAX];
    if (realpath(file_path, resolved_file) == NULL)
        return 0;

    char resolved_dir[PATH_MAX];
    if (realpath(dir_path, resolved_dir) == NULL)
        return 0;

    // Compare the directory part of both paths
    size_t dir_len = strlen(resolved_dir);
    if (strncmp(resolved_file, resolved_dir, dir_len) != 0 ||
        (resolved_file[dir_len] != '/' && resolved_file[dir_len] != '\0'))
            return 0;
    
    return 1; // File is inside the directory
}

int main() {
    const char *file_path = "/home/user/test.txt";
    const char *dir_path = "/home/user";

    if (check_file_in_dir(file_path, dir_path))
        printf("File %s is in directory %s\n", file_path, dir_path);
    else
        printf("File %s not found or outside of the specified directory.\n", file_path);

    return 0;
}