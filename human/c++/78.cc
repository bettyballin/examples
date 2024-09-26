cpp
#include <cryptopp/rsa.h>
#include <cryptopp/files.h>
#include <vector>

int main() {
    using namespace CryptoPP;

    // Generate a private key
    RSA::PrivateKey rsaPrivate;
    rsaPrivate.GenerateRandomWithKeySize(RandomNumberGenerator(), 2048);

    std::vector<byte> buffer(8192 /* buffer size */);

    ArraySink arraySink(&buffer[0], buffer.size());
    rsaPrivate.DEREncode(arraySink);

    // Initialize variable with the encoded key material
    // (excluding unwritten bytes at the end of our buffer object)
    std::vector<byte> rsaPrivateMaterial(
        &buffer[0],
        &buffer[0] + arraySink.TotalPutLength());

    RSA::PrivateKey rsaPrivate2;
    ArraySource arraySource(
        &rsaPrivateMaterial[0],
        rsaPrivateMaterial.size(),
        true);
    rsaPrivate2.BERDecode(arraySource);

    return 0;
}