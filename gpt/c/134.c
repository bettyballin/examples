
#include <string.h> // For strlen

int GenerateKey() {
    unsigned char message[] = "Pizza is great!";
    unsigned char hash[SHA256_BLOCK_SIZE];
    SHA256_CTX ctx;

    sha256_init(&ctx);
    sha256_update(&ctx, message, strlen((char*)message)); // Use strlen here
    sha256_final(&ctx, hash);

    printf("SHA256 KEY\n\n\n\n\n");

    for (int i = 0; i < SHA256_BLOCK_SIZE
