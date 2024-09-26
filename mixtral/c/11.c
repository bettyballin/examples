#include <stdio.h>
#include <string.h>

#define KEY_128 16

int main() {
    int type = 0;
    char temp_in[] = "Hello, World!";
    char ptext[sizeof(temp_in)];

    if (type == 0){
        memcpy(ptext, temp_in, (size_t) (KEY_128 < strlen(temp_in)) ? KEY_128 : strlen(temp_in));
    }
    else {
        // ... add your else clause code here
    }

    printf("%s\n", ptext);

    return 0;
}