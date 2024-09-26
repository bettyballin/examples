#include <stdio.h>
#include <string.h>

void safe_strcpy(char *dest, const char* src, int destSize){
    if (strlen(src)+1 > destSize) {
        // Handle truncation error
        fprintf(stderr, "Truncating string from %d to %d characters\n", (int)strlen(src), destSize-1);

        strncpy(dest, src, destSize - 1);
        dest[destSize-1] = '\0'; // Ensure null-termination
    } else{
       strcpy(dest, src);
   }
}

int main() {
    char src[] = "Hello, World!";
    char dest[10];

    safe_strcpy(dest, src, sizeof(dest));
    printf("%s\n", dest);

    return 0;
}