#include <stdio.h>
#include <string.h>
#include <openssl/md5.h>

int main() {
    unsigned char result[MD5_DIGEST_LENGTH];

    MD5((unsigned char*)"Hello World!", strlen("Hello World!"), (unsigned char*)&result);

    for( int i = 0; i < MD5_DIGEST_LENGTH ; ++i ) {
        printf("%.2x ", result[i]);
    }

   return 0;
}