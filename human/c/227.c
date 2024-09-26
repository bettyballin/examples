#include <stdio.h>

int main() {
    #if 0
    // old code
    printf("This will not be executed\n");
    #else
    // new code
    printf("This will be executed\n");
    #endif

    #if 1
    // new code
    printf("This will also be executed\n");
    #endif

    return 0;
}