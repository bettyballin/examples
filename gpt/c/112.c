
#include <openssl/evp.h>
#include <openssl/ec.h>
#include <openssl/sha.h>
#include <vector>
#include <cassert>

int main() {
    // Initialize OpenSSL algorithms (required for older versions of OpenSSL)
    OpenSSL_add_all_algorithms();

    // Create a new EC key
    auto evp = EVP_PKEY_new();
   
