cpp
#include <iostream>
#include <string>
#include <cryptopp/cryptlib.h>
#include <cryptopp/filters.h>
#include <cryptopp/hex.h>
#include <cryptopp/rsa.h>
#include <cryptopp/sha.h>
#include <cryptopp/err.h>

int main() {
    CryptoPP::AutoSeededRandomPool prng;
    std::string dek("30819D300D06092A864886F70D010101050003818B0030818702818100B126088"
                    "1BDFE84463D88C6AB8DB914A2E593893C10508B8A5ABDF692E9A5419A3EDBAE86"
                    "A052849983B75E3B425C18178B260003D857DF0B6505C6CF9C84F5859FCE3B63F"
                    "1FB2D4818501F6C5FA4AD1430EEB081A74ABD74CD1F4AA1FCCA3B88DD0548AED3"
                    "4443CEB52444EAE9099AA4FE66B2E6224D02381C248025C7044079020111");

    try {

        CryptoPP::ByteQueue queue;
        CryptoPP::HexDecoder decoder(new CryptoPP::Redirector(queue));

        decoder.Put((const CryptoPP::byte*)dek.data(), dek.size());
        decoder.MessageEnd();

        CryptoPP::RSASSA_PKCS1v15_SHA_Verifier verifier;
        verifier.AccessKey().Load(queue);

        if (!verifier.AccessKey().Validate(prng, 3))
            throw CryptoPP::Exception(CryptoPP::Exception::OTHER_ERROR, "Failed to validate public key");

        std::cout << "Verified key" << std::endl;
    }
    catch(CryptoPP::Exception& ex)
    {
        std::cerr << ex.what() << std::endl;
    }

    return 0;
}