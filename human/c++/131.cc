cpp
#include <iostream>
#include <string>
#include <cryptopp/rsa.h>
#include <cryptopp/pkcspad.h>
#include <cryptopp/sha.h>
#include <cryptopp/filters.h>
#include <cryptopp/base64.h>

using namespace std;
using namespace CryptoPP;

typedef RSAES<PKCS1v15>::Decryptor RSAES_PKCS1v15_Decryptor;
typedef RSAES<PKCS1v15>::Encryptor RSAES_PKCS1v15_Encryptor;

typedef RSAES<OAEP<SHA> >::Decryptor RSAES_OAEP_SHA_Decryptor;
typedef RSAES<OAEP<SHA> >::Encryptor RSAES_OAEP_SHA_Encryptor;

int main() {
    AutoSeededRandomPool rng;

    RSA::PrivateKey rsaPrivate;
    rsaPrivate.GenerateRandomWithKeySize(rng, 2048);

    RSA::PublicKey rsaPublic(rsaPrivate);

    RSAES_PKCS1v15_Encryptor e1(rsaPublic);
    RSAES_PKCS1v15_Decryptor d1(rsaPrivate);

    RSAES_OAEP_SHA_Encryptor e2(rsaPublic);
    RSAES_OAEP_SHA_Decryptor d2(rsaPrivate);

    string message = "Hello, World!";
    string encrypted, decrypted;

    e1.Encrypt(rng, (const byte*)message.data(), message.size(), encrypted);
    d1.Decrypt((const byte*)encrypted.data(), encrypted.size(), decrypted);

    cout << "PKCS1v15 decrypted: " << decrypted << endl;

    e2.Encrypt(rng, (const byte*)message.data(), message.size(), encrypted);
    d2.Decrypt((const byte*)encrypted.data(), encrypted.size(), decrypted);

    cout << "OAEP SHA decrypted: " << decrypted << endl;

    return 0;
}