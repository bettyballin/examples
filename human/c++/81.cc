cpp
#include <iostream>
#include <string>
#include <cryptopp/filters.h>
#include <cryptopp/sha.h>
#include <cryptopp/files.h>
#include <cryptopp/hex.h>

int main() {
    std::string s1, s2, s3, s4;
    CryptoPP::SHA1 sha1; 
    CryptoPP::SHA224 sha224; 
    CryptoPP::SHA256 sha256; 
    CryptoPP::SHA512 sha512;

    CryptoPP::HashFilter f1(sha1, new CryptoPP::HexEncoder(new CryptoPP::StringSink(s1)));
    CryptoPP::HashFilter f2(sha224, new CryptoPP::HexEncoder(new CryptoPP::StringSink(s2)));
    CryptoPP::HashFilter f3(sha256, new CryptoPP::HexEncoder(new CryptoPP::StringSink(s3)));
    CryptoPP::HashFilter f4(sha512, new CryptoPP::HexEncoder(new CryptoPP::StringSink(s4)));

    CryptoPP::ChannelSwitch cs;
    cs.AddDefaultRoute(f1);
    cs.AddDefaultRoute(f2);
    cs.AddDefaultRoute(f3);
    cs.AddDefaultRoute(f4);

    std::string filename = "filename.xxx";
    CryptoPP::FileSource fs(filename.c_str(), true /*pumpAll*/, new CryptoPP::Redirector(cs));

    std::string message = "Message: ";
    std::cout << message << std::endl;
    std::cout << "SHA-1: " << s1 << std::endl;
    std::cout << "SHA-224: " << s2 << std::endl;
    std::cout << "SHA-256: " << s3 << std::endl;
    std::cout << "SHA-512: " << s4 << std::endl;

    return 0;
}