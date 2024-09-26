Here is the modified code:


#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <openssl/md5.h>

void MD5hash(unsigned char *data, unsigned int dataLen, unsigned char *digest) {
    MD5_CTX c;
    MD5_Init(&c);
    MD5_Update(&c, data, dataLen);
    MD5_Final(digest, &c);
}

int main() {
    unsigned char md5_hash[MD5_DIGEST_LENGTH];
    size_t len = 0;
    ssize_t read;
    char *input = NULL;

    printf("Enter the password: ");
    if ((read = getline(&input, &len, stdin)) == -1) {
        perror("getline");
        exit(EXIT_FAILURE);
    }

    // Remove trailing newline
    input[strcspn(input, "\n")] = 0;
    
    unsigned int str_length = (unsigned int)strlen(input);

    printf("Size read: %ld Len: %zu String Length: %u\n", read, len, str_length);

    MD5hash((unsigned char *)input, str_length, md5_hash);

    printf("MD5 hash is:");
    for (int i = 0; i < MD5_DIGEST_LENGTH; i++) {
        printf("%02x", md5_hash[i]);
    }
    printf("\n");

    free(input);
    return EXIT_SUCCESS;
}


Note: Compile with `-lcrypto` flag, e.g. `gcc code.c -lcrypto -o code`