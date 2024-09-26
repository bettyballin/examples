
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <limits.h>
#include <unistd.h>

int is_file_in_directory(const char *file_path, const char *directory_path) {
    char resolved_file_path[PATH_MAX];
    char resolved_directory_path[PATH_MAX];

    // Resolve the absolute file path
    if (realpath(file_path, resolved_file_path) == NULL) {
        perror("Error resolving file path");
        return -1;
    }

    // Resolve the absolute directory path
    if (realpath(directory_path, resolved_directory_path) == NULL) {
        perror("Error resolving directory path");
        return -1;
    }

    // Check if the file path starts with the directory path
    if (strncmp(resolved_file_path, resolved_directory_path, strlen(resolved_directory_path))
