cpp
#include <cryptopp/files.h>
#include <cryptopp/rsa.h>

int main() {
    {
        CryptoPP::FileSink output("rsaparams.dat");
        InvertibleRSAFunction params;
        params.DEREncode(output);
    }

    InvertibleRSAFunction params2;
    {
        CryptoPP::FileSource input("rsaparams.dat", true);
        params2.BERDecode(input);
    }

    return 0;
}