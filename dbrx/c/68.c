#include <stdio.h>

int main() {
#if __STDC_LIB_EXT1__
    printf("Using secure versions of functions.\n");
    // Use secure versions of functions here
#else
    printf("Using insecure versions of functions for compatibility.\n");
    // Fall back to insecure versions for compatibility with older compilers/OSes
#endif

    return 0;
}