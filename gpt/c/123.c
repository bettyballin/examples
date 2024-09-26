
#include <stdlib.h>

int main() {
    int *ptr = (int *)malloc(sizeof(int)); // Allocate memory for an integer
    *ptr = 10;                             // Use the allocated memory
    // Forgot to free the memory
    return 0;
}

