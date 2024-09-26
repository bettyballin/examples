Here is the corrected and completed code:


#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <openssl/aes.h>
#include <openssl/evp.h>
#include <openssl/err.h>

void encrypt(FILE *ifp, FILE *ofp) {
    unsigned char key[] = "01234567890123456789012345678901";
    unsigned char iv[]  = "0123456789012345";

    EVP_CIPHER_CTX ctx;
    int outLen1, outLen2;

    fseek(ifp, 0L, SEEK_END);
    int fsize = ftell(ifp);
    rewind(ifp);

    unsigned char *indata = malloc(fsize + EVP_MAX_BLOCK_LENGTH);
    if (!indata) {
        perror("Error allocating memory");
        fclose(ifp);
        return;
    }

    fread(indata, sizeof(char), fsize, ifp); // Read Entire File

    EVP_EncryptInit(&ctx, EVP_aes_256_cbc(), key, iv);

    unsigned char *outdata = malloc(2 * (fsize + EVP_MAX_BLOCK_LENGTH));
    if (!outdata) {
        perror("Error allocating memory");
        free(indata);
        fclose(ifp);
        return;
    }

    EVP_EncryptUpdate(&ctx, outdata, &outLen1, indata, fsize);

    int final_len = 0;

    // Finalize encryption
    if (!EVP_EncryptFinal_ex(&ctx, outdata + outLen1, &final_len)) {
        perror("Error during encrypt");
        free(indata);
        free(outdata);
        fclose(ifp);
        return;
    }

    fwrite(outdata, sizeof(char), outLen1 + final_len, ofp);

    free(indata);
    free(outdata);
}

void decrypt(FILE *ifp, FILE *ofp) {
    unsigned char key[] = "01234567890123456789012345678901";
    unsigned char iv[]  = "0123456789012345";

    EVP_CIPHER_CTX ctx;
    int outLen1, outLen2;

    fseek(ifp, 0L, SEEK_END);
    int fsize = ftell(ifp);
    rewind(ifp);

    unsigned char *indata = malloc(fsize + EVP_MAX_BLOCK_LENGTH);
    if (!indata) {
        perror("Error allocating memory");
        fclose(ifp);
        return;
    }

    fread(indata, sizeof(char), fsize, ifp); // Read Entire File

    EVP_DecryptInit(&ctx, EVP_aes_256_cbc(), key, iv);

    unsigned char *outdata = malloc(2 * (fsize + EVP_MAX_BLOCK_LENGTH));
    if (!outdata) {
        perror("Error allocating memory");
        free(indata);
        fclose(ifp);
        return;
    }

    EVP_DecryptUpdate(&ctx, outdata, &outLen1, indata, fsize);

    int final_len = 0;

    // Finalize decryption
    if (!EVP_DecryptFinal_ex(&ctx, outdata + outLen1, &final_len)) {
        perror("Error during decrypt");
        free(indata);
        free(outdata);
        fclose(ifp);
        return;
    }

    fwrite(outdata, sizeof(char), outLen1 + final_len, ofp);

    free(indata);
    free(outdata);
}

int main(int argc, char **argv) {
    FILE *fIN, *fOUT;

    fIN = fopen("plain.txt", "rb");
    if (!fIN) {
        perror("Error opening plain.txt");
        return 1;
    }

    fOUT = fopen("encrypted.txt", "wb");
    if (!fOUT) {
        perror("Error opening encrypted.txt");
        fclose(fIN);
        return 1;
    }

    encrypt(fIN, fOUT);
    fclose(fIN);
    fclose(fOUT);

    fIN = fopen("encrypted.txt", "rb");
    if (!fIN) {
        perror("Error opening encrypted.txt");
        return 1;
    }

    fOUT = fopen("decrypted.txt", "wb");
    if (!fOUT) {
        perror("Error opening decrypted.txt");
        fclose(fIN);
        return 1;
    }

    decrypt(fIN, fOUT);
    fclose(fIN);
    fclose(fOUT);

    return 0;
}