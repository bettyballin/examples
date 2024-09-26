#include <stdio.h>

size_t fread(void * restrict ptr, size_t size, size_t nmemb, FILE * restrict stream) {
    // implementation of fread is system-dependent, so we'll use the standard library implementation
    return fread(ptr, size, nmemb, stream);
}

int main() {
    FILE *file = fopen("example.txt", "r");
    if (file == NULL) {
        perror("Error opening file");
        return 1;
    }

    char buffer[1024];
    size_t bytes_read = fread(buffer, 1, 1024, file);
    if (bytes_read == 0) {
        perror("Error reading file");
        return 1;
    }

    printf("Read %zu bytes from file\n", bytes_read);

    fclose(file);
    return 0;
}