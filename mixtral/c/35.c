pp
#include <windows.h>
#include <wincrypt.h>
#include <vector>
#include <string>
#include <stdexcept>

// Encryption
std::vector<BYTE> ProtectData(const std::string& plaintext, const std::vector<BYTE>& entropy) {
    DATA_BLOB in;
    in.pbData = (BYTE*)plaintext.c_str();
    in.cbData = static_cast<DWORD>(plaintext.size());

    DATA_BLOB out;

    if (!CryptProtectData(
        &in,
        L"My Data",
        nullptr,
        nullptr,
        nullptr,
        0,
        &out)) {
            throw std::runtime_error("Failed to encrypt data");
    }

    std::vector<BYTE> result(out.pbData, out.pbData + out.cbData);
    LocalFree(out.pbData);
    return result;
}

// Decryption
std::string UnprotectData(const std::vector<BYTE>& ciphertext) {
    DATA_BLOB in;
    in.pbData = (BYTE*)ciphertext.data();
    in.cbData = static_cast<DWORD>(ciphertext.size());

    DATA_BLOB out;

    if (!CryptUnprotectData(
        &in,
        nullptr,
        nullptr,
        nullptr,
        nullptr,
        0,
        &out)) {
            throw std::runtime_error("Failed to decrypt data");
    }

    std::string result((char*)out.pbData, out.cbData);
    LocalFree(out.pbData);
    return result;
}

int main() {
    std::string plaintext = "Hello, World!";
    std::vector<BYTE> entropy;

    std::vector<BYTE> ciphertext = ProtectData(plaintext, entropy);

    std::string decrypted = UnprotectData(ciphertext);

    return 0;
}