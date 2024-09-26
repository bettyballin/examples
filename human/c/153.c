#include <stdio.h>
#include <stdlib.h>
#include <errno.h>

long get_content_length(void)
{
    char *content_length, *endp;
    long rv;

    content_length = getenv("CONTENT_LENGTH");
    if (!content_length) return -1;
    errno = 0;
    rv = strtol(content_length, &endp, 10);
    if (endp == content_length || *endp || errno || rv <= 0)
        return -1;
    return rv;
}

int main() {
    long content_length = get_content_length();
    if(content_length == -1) {
        printf("Error getting content length\n");
    } else {
        printf("Content length: %ld\n", content_length);
    }
    return 0;
}