cpp
#include <stdio.h>
#include <string.h>
#include <openssl/sha.h>

int do_sha1_file(char *name, unsigned char *out)
{
    FILE *f;
    unsigned char buf[8192];
    SHA_CTX sc;
    int err;

    f = fopen(name, "rb");
    if (f == NULL) {
        return -1;
    }
    SHA1_Init(&sc);
    for (;;) {
        size_t len;

        len = fread(buf, 1, sizeof buf, f);
        if (len == 0)
            break;
        SHA1_Update(&sc, buf, len);
    }
    err = ferror(f);
    fclose(f);
    if (err) {
        return -1;
    }
    SHA1_Final(out, &sc);
    return 0;
}

int main()
{
    unsigned char hash[20];
    char filename[] = "test.txt";
    if (do_sha1_file(filename, hash) == 0) {
        for (int i = 0; i < 20; i++) {
            printf("%02x", hash[i]);
        }
        printf("\n");
    } else {
        printf("Error hashing file\n");
    }
    return 0;
}