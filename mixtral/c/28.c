#include <stdio.h>
#include <stdlib.h>

int main() {
    FILE *fin = fopen("input.txt", "rb");
    if (!fin) {
        perror("Error opening input file");
        return EXIT_FAILURE;
    }

    char buf1[4];
    size_t bytesRead = fread(&buf1, 4, 1, fin);
    if (bytesRead < 1) {
        if (feof(fin)) {
            printf("End of file reached\n");
        } else if (ferror(fin)) {
            perror("Error reading from input file");
        }
        fclose(fin);
        return EXIT_FAILURE;
    }

    // Proceed with encryption and writing to output file
    // ...

    fclose(fin);
    return EXIT_SUCCESS;
}