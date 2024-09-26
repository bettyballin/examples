cpp
#include <cryptopp/files.h>
#include <cryptopp/filters.h>
#include <cryptopp/hex.h>
#include <cryptopp/hash.h>
#include <vector>
#include <string>

int main() {
    std::vector<std::string> output;
    std::string p = "path_to_your_file";
    CryptoPP::HashFilter hash(new CryptoPP::SHA256);
    CryptoPP::FileSource(p.c_str(), true, new CryptoPP::HashFilter(hash, new CryptoPP::HexEncoder(new CryptoPP::StringSink(output))), true);
    return 0;
}