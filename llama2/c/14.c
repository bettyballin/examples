#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define _CRT_SECURE_NO_WARNINGS

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <option>\n", argv[0]);
        return 1;
    }

    char *opt = argv[1];
    char buffer[1024];

    // Sanitize input by only allowing a single - followed by a string
    char* token = strtok(opt, "-");
    if (strcmp(opt, "-") != 0 && (token == NULL || strtok(NULL, "-") != NULL)) {
        fprintf(stderr, "Invalid option: %s\n", opt);
        return 1;
    }

    // Build the command using strcpy_s and strcat_s
    strcpy_s(buffer, 1024, "command ");
    strcat_s(buffer, 1024, opt);

    // Print the command for demonstration purposes
    printf("%s\n", buffer);

    return 0;
}