#include <stdlib.h>

int main() {
    unsigned char *out;
    size_t len = 10; // replace with your desired length

    if (!(out = (unsigned char*)malloc((len + 1)* sizeof(unsigned char)))) {
        return -1; // allocation failed
    }

    // use the allocated memory here...

    free(out);
    return 0;
}