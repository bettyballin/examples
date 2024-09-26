#include <iostream>
#include <vector>
#include <string>
#include <openssl/rsa.h>
#include <openssl/err.h>

int main() {
    char TestString[] = "d7f3h47k";  // 8 long obviously
    RSA *RSAKey = RSA_new();
    BIGNUM *bne = BN_new();
    BN_set_word(bne, RSA_F4);
    RSA_generate_key_ex(RSAKey, 2048, bne, NULL);

    unsigned int EncryptedLength;
    unsigned char* encryptedData = (unsigned char*)malloc(RSA_size(RSAKey));
    if ((EncryptedLength = RSA_public_encrypt(strlen(TestString), (unsigned char*)TestString, encryptedData, RSAKey, RSA_PKCS1_OAEP_PADDING)) == -1) {
        ERR_print_errors_fp(stderr);
        printf("Failed encrypt.\n");
        getchar();
        return 1;
    }

    unsigned int DecryptedLength;
    unsigned char* decryptedData = (unsigned char*)malloc(EncryptedLength);
    if ((DecryptedLength = RSA_private_decrypt(EncryptedLength, encryptedData, decryptedData, RSAKey, RSA_PKCS1_OAEP_PADDING)) == -1) {
        ERR_print_errors_fp(stderr);
        printf("Failed decrypt.\n");
        getchar();
        return 1;
    }

    decryptedData[DecryptedLength] = '\0';

    std::string_view OriginalString((char*)decryptedData);

    std::cout << "Original string: " << OriginalString << std::endl;

    free(encryptedData);
    free(decryptedData);
    RSA_free(RSAKey);
    BN_free(bne);

    return 0;
}