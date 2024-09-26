#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    char *test_data = "Hello World!";
    unsigned char *str;
    size_t len = strlen(test_data);

    // Allocate memory for the input message
    str = malloc((len + 1) * sizeof(*str));

    if (str == NULL){
        printf("Memory allocation failed\n");
        return 1;
    }

    memcpy(str, test_data, len+1);

    printf("%s\n", str);

    free(str);

    return 0;
}