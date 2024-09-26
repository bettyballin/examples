#include <stdio.h>
#include <stdlib.h>

int main() {
    unsigned char *aes_key = malloc(32*sizeof(unsigned char));
    
    if ((32/sizeof(aes_key[0])) != 32) {
        printf("Key size mismatch\n");
    } else {
        printf("Key size match\n");
    }

    free(aes_key);
    return 0;
}