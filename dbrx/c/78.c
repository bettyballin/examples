#include <stdio.h>
#include <stdlib.h>

int main() {
    int *ptr;
    ptr = (int *)malloc(sizeof(int));
    if(ptr == NULL) {
        printf("Memory not allocated.");
        exit(0);
    }
    free(ptr);  
    return 0; 
}