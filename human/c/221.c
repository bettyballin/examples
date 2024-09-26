#include <stdio.h>
#include <stdlib.h>
#include <openssl/bn.h>
#include <openssl/evp.h>

int main(void) {
  BIGNUM *bns[3];
  bns[0] = BN_new();
  bns[1] = BN_new();
  bns[2] = BN_new();
  BN_set_word(bns[0], 10);
  BN_set_word(bns[1], 50);
  BN_set_word(bns[2], 150);

  EVP_MD_CTX *hash_ctx = EVP_MD_CTX_new();
  EVP_DigestInit_ex(hash_ctx, EVP_sha256(), NULL);

  unsigned char *bytes = NULL;
  for (int n = 0; n < 3; n++) {
    size_t size = BN_num_bytes(bns[n]);
    bytes = realloc(bytes, size);
    BN_bn2bin(bns[n], bytes);
    EVP_DigestUpdate(hash_ctx, bytes, size);
  }
  free(bytes);

  unsigned char hash[EVP_MAX_MD_SIZE];
  unsigned hash_size = EVP_MAX_MD_SIZE;
  EVP_DigestFinal_ex(hash_ctx, hash, &hash_size);
  EVP_MD_CTX_free(hash_ctx);

  for (unsigned n = 0; n < hash_size; n++) {
    printf("%02hhx", hash[n]);
  }
  putchar('\n');

  BN_free(bns[0]);
  BN_free(bns[1]);
  BN_free(bns[2]);

  return 0;
}