cpp
#include <iostream>
#include <string>
#include <cstdint>
#include <cryptopp/cryptlib.h>
#include <cryptopp/hex.h>
#include <cryptopp/rsa.h>

using namespace std;
using namespace CryptoPP;

// Function to convert public key to string
string public_key_to_string(PublicKey publicKey){
    string ss;
    StringSink sink(ss);
    publicKey.Save(sink);
    string encoded;
    HexEncoder encoder;
    encoder.Put((byte*)ss.data(), ss.size());
    encoder.MessageEnd();
    word64 size = encoder.MaxRetrievable();
    if(size)
    {
        encoded.resize(size);
        encoder.Get((byte*)&encoded[0], encoded.size());
    }
    std::cout << "key in hex: " << encoded;

    return encoded;
}

// Function to convert string to public key
RSA::PublicKey string_to_publicKey(string keyInHex){
    string decodedKey;
    HexDecoder decoder;
    decoder.Put( (byte*)keyInHex.data(), keyInHex.size() );
    decoder.MessageEnd();

    word64 size = decoder.MaxRetrievable();
    if(size && size <= SIZE_MAX)
    {
        decodedKey.resize(size);
        decoder.Get((byte*)&decodedKey[0], decodedKey.size());
    }
    cout << "Decoded : " << decodedKey << endl;
    StringSource ss(decodedKey, true);
    RSA::PublicKey pubKey;
    pubKey.Load(ss);

    return pubKey;
}

int main(){
    // Generate a random public key
    AutoSeededRandomPool rng;
    RSA::PrivateKey privateKey;
    privateKey.GenerateRandomWithKeySize(rng, 3072);
    RSA::PublicKey publicKey(privateKey);

    // Convert public key to string
    string publicKeyStr = public_key_to_string(publicKey);

    // Convert string back to public key
    RSA::PublicKey publicKey2 = string_to_publicKey(publicKeyStr);

    return 0;
}