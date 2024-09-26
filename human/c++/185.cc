cpp
#include <iostream>
#include <string>
#include <openssl/rsa.h>
#include <openssl/bn.h>

struct KeyPair {
  std::string privateKey;
  std::string publicKey;
};

KeyPair RsaGenerateHexKeyPair(int bits) {
  RSA *keypair = RSA_new();
  BIGNUM *exponent = BN_new();
  BN_set_word(exponent, 65537);
  RSA_generate_key_ex(keypair, bits, exponent, NULL);

  BIO *bioPrivate = BIO_new(BIO_s_mem());
  PEM_write_bio_RSAPrivateKey(bioPrivate, keypair, NULL, NULL, 0, NULL, NULL);
  char *privateKey;
  long privateKeyLen = BIO_get_mem_data(bioPrivate, &privateKey);
  std::string privateString(privateKey, privateKeyLen);

  BIO *bioPublic = BIO_new(BIO_s_mem());
  PEM_write_bio_RSAPublicKey(bioPublic, keypair);
  char *publicKey;
  long publicKeyLen = BIO_get_mem_data(bioPublic, &publicKey);
  std::string publicString(publicKey, publicKeyLen);

  RSA_free(keypair);
  BN_free(exponent);
  BIO_free(bioPrivate);
  BIO_free(bioPublic);

  return {privateString, publicString};
}

int main(int, char **) {
  auto keys = RsaGenerateHexKeyPair(3072);
  std::cout << "Private key: " << std::endl << keys.privateKey << "\n" << std::endl;

  std::cout << "Public key: " << std::endl << keys.publicKey << "\n" << std::endl;

  return 0;
}