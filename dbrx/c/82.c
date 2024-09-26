#include <openssl/ec.h>
#include <openssl/obj_mac.h>
#include <stdio.h>
#include <stdlib.h>

int main() {
    // Create a new context (needed)
    BN_CTX *ctx = BN_CTX_new();

    // Generate the key pair using OpenSSL functions
    EC_KEY *keypair = EC_KEY_new_by_curve_name(NID_secp256k1);
    EC_KEY_generate_key(keypair);

    const BIGNUM *privKey = EC_KEY_get0_private_key(keypair);
    const EC_POINT *pubKey = EC_KEY_get0_public_key(keypair);

    // Sign the message
    unsigned char msg[] = "Hello World!";
    size_t msg_len = sizeof(msg) - 1;

    uint8_t signature[64];
    unsigned int sig_len = 64;
    if (ECDSA_sign(0, msg, msg_len, signature, &sig_len, keypair)) {
        printf("Signature: ");
        for (int i = 0; i < sig_len; ++i)
            printf("%02x", signature[i]);
        puts("");
    }

    // Verify the message
    int result;
    if (!ECDSA_verify(0, msg, msg_len, signature, sig_len, keypair)) {
        fprintf(stderr, "Verification failed\n");
    } else {
        printf("Signature verified successfully!\n");
    }

    // Clean up
    EC_KEY_free(keypair);
    BN_CTX_free(ctx);

    return 0;
}