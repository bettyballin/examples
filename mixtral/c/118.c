I can't execute the code, but I can provide the corrected code:



#include <openssl/pem.h>
#include <openssl/evp.h>
#include <iostream>
#include <string>
#include <vector>

bool EncryptString(const std::string& InStr, const std::string& InPublicKey, std::string& OutString) {
  // Load the public key
  BIO* bio = BIO_new_mem_buf((void*)InPublicKey.c_str(), -1);

  EVP_PKEY *pkkey;

  if (!PEM_read_bio_PUBKEY(bio, &pkkey, NULL, NULL)) {
    BIO_free(bio);
    return false;
  }

  // Create the encryption context
  EVP_CIPHER_CTX* ctx = EVP_CIPHER_CTX_new();
  const EVP_CIPHER* cipher = EVP_get_cipherbyname("RSA");

  if (!EVP_EncryptInit_ex(ctx, cipher, NULL, pkkey->pkey.rsa, NULL)) {
    EVP_CIPHER_CTX_free(ctx);
    EVP_PKEY_free(pkkey);
    BIO_free(bio);
    return false;
  }

  // Encryption

  int outlen1 = InStr.size() + EVP_MAX_IV_LENGTH;

  std::vector<unsigned char> OutBuf(outlen1);

  int outlen = 0;
  if (!EVP_EncryptUpdate(ctx, OutBuf.data(), &outlen, (const unsigned char*)InStr.c_str(), InStr.size())) {
    EVP_CIPHER_CTX_free(ctx);
    EVP_PKEY_free(pkkey);
    BIO_free(bio);
    return false;
  }

  int outlen2 = 0;
  if (!EVP_EncryptFinal_ex(ctx, OutBuf.data() + outlen, &outlen2)) {
    EVP_CIPHER_CTX_free(ctx);
    EVP_PKEY_free(pkkey);
    BIO_free(bio);
    return false;
  }

  OutString = std::string((char*)OutBuf.data(), outlen + outlen2);

  EVP_CIPHER_CTX_free(ctx);
  EVP_PKEY_free(pkkey);
  BIO_free(bio);

  return true;
}

int main() {
  std::string InStr = "Hello, World!";
  std::string InPublicKey = "-----BEGIN PUBLIC KEY-----\n"
                            "...\n"
                            "-----END PUBLIC KEY-----\n";
  std::string OutString;

  if (EncryptString(InStr, InPublicKey, OutString)) {
    std::cout << "Encrypted string: " << OutString << std::endl;
  } else {
    std::cout << "Encryption failed" << std::endl;
  }

  return 0;
}

Note: You should replace the `InPublicKey` variable with your actual public key in PEM format.