cpp
#include <iostream>
#include <vector>
#include <string>
#include "cryptopp/files.h"
#include "cryptopp/filters.h"
#include "cryptopp/hex.h"
#include "cryptopp/sha.h"

int main() {
    std::vector<std::string> output;
    std::string str;
    std::string fname = "path_to_your_file";

    CryptoPP::SHA256 hash;
    CryptoPP::FileSource(fname.c_str(), true, new CryptoPP::HashFilter(hash, new CryptoPP::HexEncoder(new CryptoPP::StringSink(str))), true);

    output.push_back(str);

    for (const auto& s : output) {
        std::cout << s << std::endl;
    }

    return 0;
}