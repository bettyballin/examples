cpp
#include <iostream>
#include <string>
#include <openssl/bio.h>
#include <openssl/ec.h>
#include <openssl/ecdsa.h>
#include <openssl/pem.h>

int main() {
    std::string key_ = "your_key_here";
    std::string msghash = "your_msghash_here";
    std::string sig = "your_sig_here";

    BIO* bio = BIO_new_mem_buf(key_.data(), key_.length());

    EC_KEY* key = PEM_read_bio_EC_PUBKEY(bio, nullptr, nullptr, nullptr);

    int verified = ECDSA_verify(
        0,
        (unsigned char const*)msghash.data(), msghash.length(),
        (unsigned char const*)sig.data(), sig.length(),
        key
    );

    std::cout << verified << std::endl;

    BIO_free(bio);
    EC_KEY_free(key);

    return 0;
}