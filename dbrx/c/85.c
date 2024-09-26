#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>

int base64_decode(const char *data, unsigned char **decoded_data)
{
    size_t len = strlen(data);
    int i;
    for (i=0; data[i]; ++i) if (!isalnum(data[i]) && !isspace(data[i])) return 1;

    // ... 
}

int main() {
    const char *data = "SGVsbG8gd29ybGQh"; // example base64 encoded string
    unsigned char *decoded_data;
    int ret = base64_decode(data, &decoded_data);
    if (ret == 1) {
        printf("Invalid character found in the input string\n");
    } else {
        // Add your logic to handle the decoded data here
        printf("Decoded data: %s\n", decoded_data);
        free(decoded_data);
    }
    return 0;
}