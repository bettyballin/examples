
#include <stdio.h>
#include <stdlib.h>
#include <openssl/evp.h>
#include <openssl/pem.h>
#include <openssl/err.h>

void main() {
    EVP_MD_CTX *mdctx;
    EVP_PKEY *pkey;
    char dmessage[] = "The messages";
    size_t dmessage_len = strlen(dmessage); // Use strlen to determine the length of the message
    int ret = 0;
    FILE *fp;
    unsigned char *sig = NULL;
    size_t slen;

    fp = fopen("privkey.pem", "r");
    if (fp == NULL) exit(1);
    pkey = PEM_read_PrivateKey(fp, NULL, NULL, NULL);
    fclose(fp);

    if (pkey == NULL) {
        ERR_print_errors_fp(stderr);
        exit(1);
    }

    mdctx = EVP_MD_CTX_create();
    if (!mdctx) goto err;
    if (
