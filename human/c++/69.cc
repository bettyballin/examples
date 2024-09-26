cpp
#include <cryptopp/filters.h>
#include <cryptopp/signature.h>
#include <cryptopp/rsa.h>
#include <cryptopp/sha.h>
#include <cryptopp/base64.h>
#include <cryptopp/files.h>

#include <string>
using namespace CryptoPP;

int main() {
    std::string signature = "your_signature";
    std::string message = "your_message";

    RSASSA_PKCS1v15_SHA256_Verifier verifier;
    verifier.AccessKey().Load("your_public_key.der");

    StringSource ss(signature + message, true,
        new SignatureVerificationFilter(
        verifier, NULL,
        THROW_EXCEPTION | SIGNATURE_AT_BEGIN
            ) // SignatureVerificationFilter   
            ); // StringSource

    return 0;
}