
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <libgen.h>
#include <unistd.h>

#define BASE_DIR "/path/to/your/server/directory"

int is_safe_path(const char *filename) {
    char *resolved_path;
    char *base_resolved_path;
    int is_safe = 0;

    // Resolve the absolute path of the base directory
    base_resolved_path = realpath(BASE_DIR, NULL);

    // Resolve the absolute path of the requested file
    resolved_path = realpath(filename, NULL);

   
