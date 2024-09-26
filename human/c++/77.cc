cpp
#include <cryptopp/rsa.h>
#include <cryptopp/files.h>

int main() {
    // Generate parameters
    CryptoPP::InvertibleRSAFunction params;
    params.GenerateRandomWithKeySize(CryptoPP::RandomNumberGenerator(), 2048);

    // Initialize keys from generated params
    CryptoPP::RSA::PrivateKey rsaPrivate(params);
    CryptoPP::RSA::PublicKey rsaPublic(params);

    // Write keys to file
    {
        CryptoPP::FileSink output("rsaprivate.dat");
        rsaPrivate.DEREncode(output);
    }
    {
        CryptoPP::FileSink output("rsapublic.dat");
        rsaPublic.DEREncode(output);
    }

    // Read keys from file into new objects
    CryptoPP::RSA::PrivateKey rsaPrivate2;
    CryptoPP::RSA::PublicKey rsaPublic2;
    {
        CryptoPP::FileSource input("rsaprivate.dat", true);
        rsaPrivate2.BERDecode(input);
    }
    {
        CryptoPP::FileSource input("rsapublic.dat", true);
        rsaPublic2.BERDecode(input);
    }

    return 0;
}