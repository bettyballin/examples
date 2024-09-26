#include <stdio.h>
#include <stdlib.h>

int main() {
    int array[0x200/4]; // assuming 4-byte integers
    int *argv1 = (int *)malloc(sizeof(int));
    int *ptr1 = (int *)malloc(sizeof(int));
    int *ptr2 = (int *)malloc(sizeof(int));

    // Initialize eax value, for demonstration purposes
    int eax = 10;

    // mov    DWORD PTR [esp+0x4],eax
    *(ptr1 + 1) = eax;

    // mov    DWORD PTR [esp],eax
    *ptr2 = eax;

    free(argv1);
    free(ptr1);
    free(ptr2);

    return 0;
}