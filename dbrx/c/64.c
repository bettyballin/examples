#include <stdlib.h>
#include <string.h>
#include <stdio.h>

#define MAX_LEN 512

int main(void)
{
    size_t requiredSize;
    char some[MAX_LEN];

    // Get the length needed for 'some'
    getenv_s(&requiredSize, NULL, 0, "CONTENT_LENGTH");

    if (requiredSize > sizeof(some))
        return -1; // Buffer too small!

    // Now get the actual value
    getenv_s(NULL, some, requiredSize, "CONTENT_LENGTH");
    
    printf("Content-Length: %s\n", some);

    return 0;
}