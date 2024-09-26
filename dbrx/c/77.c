#include <stdio.h>
#include <stdlib.h>

int main() {
    int *ptr;
    ptr = (int *)malloc(sizeof(int));
    if(ptr == NULL) {
        printf("Memory not allocated.\n");
        exit(0);
    }
    free(ptr); // deallocate memory when no longer needed
    return 0;
}