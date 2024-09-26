cpp
#include <botan/botan.h>
#include <botan/pbkdf.h>
#include <botan/hmac.h>
#include <botan/sha160.h>
#include <botan/rng.h>
#include <botan/byte_string.h>
#include <botan/secure_vector.h>

int main() {
    Botan::LibraryInitializer init;

    Botan::PKCS5_PBKDF2 pbkdf2(new Botan::HMAC(new Botan::SHA_160));

    const uint32_t PBKDF2_ITERATIONS = 8192;

    Botan::SecureVector<Botan::byte> salt(8);
    Botan::RNG rng;
    rng.randomize(&salt[0], salt.size());

    std::string passphrase = "your_passphrase_here";
    Botan::SecureVector<Botan::byte> master_key = pbkdf2.derive_key(48, passphrase,
                                                 &salt[0], salt.size(),
                                                 PBKDF2_ITERATIONS).bits_of();

    return 0;
}