#include <openssl/bn.h>
#include <openssl/sha.h>
#include <stdio.h>

void hash_multiple_bignum(BIGNUM **bn, int count, unsigned char *output) {
    SHA256_CTX ctx;
    SHA256_Init(&ctx);

    for (int i = 0; i < count; ++i) {
        uint8_t *bin = (uint8_t *)malloc(BN_num_bytes(bn[i]));
        BN_bn2bin(bn[i], bin);
        SHA256_Update(&ctx, bin, BN_num_bytes(bn[i]));
        free(bin);
    }

    SHA256_Final(output, &ctx);
}

int main() {
    BIGNUM *bn1 = BN_new();
    BIGNUM *bn2 = BN_new();
    BN_set_word(bn1, 12345);
    BN_set_word(bn2, 67890);

    unsigned char output[SHA256_DIGEST_LENGTH];
    BIGNUM *bn[] = {bn1, bn2};
    hash_multiple_bignum(bn, 2, output);

    for (int i = 0; i < SHA256_DIGEST_LENGTH; i++) {
        printf("%02x", output[i]);
    }
    printf("\n");

    BN_free(bn1);
    BN_free(bn2);
    return 0;
}