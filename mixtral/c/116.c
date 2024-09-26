#include <openssl/bn.h>
#include <openssl/evp.h>
#include <string>
#include <iostream>

int main() {
    BIGNUM *n1 = BN_new(), *n2 = BN_new(), *n3 = BN_new(), *n4 = BN_new(), *n5 = BN_new(),
        *n6 = BN_new(), *n7 = BN_new(), *n8 = BN_new(), *n9 = BN_new(), *n10 = BN_new();

    // Initialize BN numbers
    BN_set_word(n1, 1);
    BN_set_word(n2, 2);
    BN_set_word(n3, 3);
    BN_set_word(n4, 4);
    BN_set_word(n5, 5);
    BN_set_word(n6, 6);
    BN_set_word(n7, 7);
    BN_set_word(n8, 8);
    BN_set_word(n9, 9);
    BN_set_word(n10, 10);

    unsigned char md[EVP_MAX_MD_SIZE];
    int len = 0;

    // Initialize the hash context
    const EVP_MD *mdtype = EVP_sha256();
    EVP_MD_CTX *ctx = EVP_MD_CTX_new();

    if (!EVP_DigestInit(ctx, mdtype)) {
        std::cerr << "EVP_DigestInit failed" << std::endl;
        return 1;
    }

    // Update the hash context with each BN
    BIGNUM* n[10] = {n1, n2, n3, n4, n5, n6, n7, n8, n9, n10};
    for (int i = 0; i < 10; ++i) {
        unsigned char *buf = NULL;
        int bufLen = BN_num_bytes(n[i]);

        if ((buf = OPENSSL_malloc(bufLen)) == NULL) {
            std::cerr << "OPENSSL_malloc failed" << std::endl;
            return 1;
        }

        memset(buf, 0x00, bufLen);

        len += bufLen;

        BN_bn2bin(n[i], buf);

        if (!EVP_DigestUpdate(ctx, buf, bufLen)) {
            std::cerr << "EVP_DigestUpdate failed" << std::endl;
            return 1;
        }

        OPENSSL_free(buf);
    }

    // Finalize the hash
    if (1 != EVP_DigestFinal(ctx, md, &len)) {
        std::cerr << "EVP_DigestFinal failed" << std::endl;
        return 1;
    }

    EVP_MD_CTX_destroy(ctx);

    // Print the hash
    std::cout << "Hash: ";
    for (int i = 0; i < len; ++i) {
        std::cout << std::hex << (int)md[i];
    }
    std::cout << std::endl;

    // Free BN numbers
    BN_free(n1);
    BN_free(n2);
    BN_free(n3);
    BN_free(n4);
    BN_free(n5);
    BN_free(n6);
    BN_free(n7);
    BN_free(n8);
    BN_free(n9);
    BN_free(n10);

    return 0;
}