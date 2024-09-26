#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {
    char *env_var = getenv("CONTENT_LENGTH");
    if (env_var != NULL) {
        size_t len = strlen(env_var);
        char *buffer = malloc(len + 1);
        if (buffer == NULL) {
            perror("malloc failed");
            return 1;
        }
        memcpy(buffer, env_var, len + 1);
        // Use the copied string here
        printf("%s\n", buffer);
        free(buffer);
    } else {
        fprintf(stderr, "Environment variable CONTENT_LENGTH not found.\n");
        return 1;
    }
    return 0;
}