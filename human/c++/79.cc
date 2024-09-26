cpp
#include <cryptopp/rsa.h>
#include <cryptopp/files.h>
#include <string>

int main() {
    using namespace CryptoPP;

    InvertibleRSAFunction params;
    params.GenerateRandomWithKeySize( rng, 2048 );

    RSA::PrivateKey rsaPrivate(params);

    std::string rsaPrivateMaterial;
    StringSink stringSink(rsaPrivateMaterial);
    rsaPrivate.DEREncode(stringSink);

    RSA::PrivateKey rsaPrivate2;
    StringSource stringSource(rsaPrivateMaterial, true);
    rsaPrivate2.BERDecode(stringSource);

    return 0;
}