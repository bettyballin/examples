
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

int main(){
    unsigned char md5_hash[MD5_DIGEST_LENGTH];
    char *input = NULL;
    int i;
    size_t len;

    printf("Enter the password: ");
    if(getline(&input, &len, stdin) == -1)
