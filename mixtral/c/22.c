#include <stdio.h>
#include <openssl/rsa.h>
#include <openssl/err.h>

int main()
{
    char TestString[] = "d7f3h47k";

    RSA *RSACKey = RSA_generate_key(2048, 65537, NULL, NULL);

    unsigned char EncryptedData[RSA_size(RSACKey)];

    if (RSA_public_encrypt(strlen((char *)TestString), (const unsigned char *)TestString, EncryptedData, RSACKey, RSA_PKCS1_OAEP_PADDING) == -1) {
        printf("Failed encrypt.\n");
        ERR_print_errors_fp(stderr);
        return 1;
    }

    unsigned char DecryptedData[RSA_size(RSACKey)];

    int EncryptLength = RSA_private_decrypt(RSA_size(RSACKey), EncryptedData, DecryptedData, RSACKey, RSA_PKCS1_OAEP_PADDING);

    if (EncryptLength == -1) {
        printf("Failed decrypt.\n");
        ERR_print_errors_fp(stderr);
        return 1;
    }

    // Null-terminate the DecryptedData to print it as a string
    char PrintableDecrypted[EncryptLength + 1];

    for (int i = 0; i < EncryptLength; ++i) {
        PrintableDecrypted[i] = (char)DecryptedData[i];
    }
    PrintableDecrypted[EncryptLength] = '\0';

    printf("Decrypted: %s\n", PrintableDecrypted);

    RSA_free(RSACKey);
    return 0;
}