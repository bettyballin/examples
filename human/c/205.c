#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <openssl/evp.h>
#include <openssl/err.h>
#include <openssl/ssl.h>

void err (int n, const char * s){ 
    printf("%s:%d\n", s, n); 
    ERR_print_errors_fp(stdout); 
    exit(1); 
}

int main (int argc, char **argv){
    if( argc != 5 || strlen(argv[3]) != 16 || strlen(argv[4]) > 16 ){ 
        printf("bad args\n"); 
        exit(1); 
    }
    const char * pw = argv[1], * salt = argv[2], * iv = argv[3], * org = argv[4];
    unsigned char key [32], pad [16], enc [16], b64 [25], unb [16], dec [16];
    int rc, len, temp, i, j;
    SSL_library_init();

    /* for both */
    rc = PKCS5_PBKDF2_HMAC (pw, strlen(pw), (unsigned char*)salt, strlen(salt), 65536, EVP_sha256(), 32, key);
    if( rc != 1 ) err(rc,"PBKDF2");
    EVP_CIPHER_CTX *ctx = EVP_CIPHER_CTX_new();

    /* for encrypt */
    len = strlen(org); 
    memset(pad, ' ', 16-len); 
    memcpy (pad+16-len, org, len);
    rc = EVP_EncryptInit (ctx, EVP_aes_256_cbc(), key, (unsigned char*)iv);
    if( rc != 1 ) err(rc,"EncryptInit");
    rc = EVP_CIPHER_CTX_set_padding(ctx,0);
    if( rc != 1 ) err(rc,"set_padding");
    rc = EVP_EncryptUpdate (ctx, enc, &len, pad, 16);
    if( rc != 1 || len != 16 ) err(rc,"EncryptUpdate");
    rc = EVP_EncryptFinal (ctx, enc+len, &temp); 
    if( rc != 1 || temp != 0 ) err(rc,"EncryptFinal");
    rc = EVP_EncodeBlock(b64, enc, 16);
    if( rc <= 0 ) err(rc,"EncodeBlock");

    printf ("%.*s\n", rc, b64);

    /* for decrypt */
    rc = EVP_DecodeBlock(unb, b64, /*len*/rc)-(b64[rc-1]=='=')-(b64[rc-2]=='=');
    /* this is a hack, should go for DecodeInit,Update,Final */
    if( rc != 16 ) err(rc,"DecodeBlock");
    rc = EVP_DecryptInit (ctx, EVP_aes_256_cbc(), key, (unsigned char*)iv);
    if( rc != 1 ) err(rc,"DecryptInit");
    rc = EVP_CIPHER_CTX_set_padding(ctx,0);
    if( rc != 1 ) err(rc,"set_padding");
    rc = EVP_DecryptUpdate (ctx, dec, &len, unb, 16);
    if( rc != 1 || len != 16 ) err(rc,"DecryptUpdate");
    rc = EVP_DecryptFinal (ctx, dec+len, &temp); 
    if( rc != 1 || temp != 0 ) err(rc,"DecryptFinal");
    i=0; 
    while(i<16&&dec[i]<=' ') i++; 
    j=16; 
    while(j>0&&dec[j-1]<=' ') j--;

    printf ("%.*s\n", j-i, dec+i);
    /* note this is NOT a C string -- needs to be copied and NUL added for that */

    EVP_CIPHER_CTX_free(ctx);
    return 0;
}