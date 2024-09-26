cpp
#include <iostream>
#include <vector>
#include <string>
#include <cstdint>
#include <algorithm>

// Assuming you have the following functions defined elsewhere
void aes_set_key(void* ctx, const unsigned char* key, int keysize);
void aes_encrypt(void* ctx, const uint8_t* plain, uint8_t* enc);
void aes_decrypt(void* ctx, const uint8_t* enc, uint8_t* plain);
void print_hex(std::vector<uint8_t>::iterator begin, std::vector<uint8_t>::iterator end);

struct aes_context {
    // assuming this is defined elsewhere
};

int main()
{
    unsigned char key[] = "0123456789ABCDEF";
    aes_context ctx = {};
    aes_set_key(&ctx, key, 128);

    // some simple message to encrypt
    std::string str = "some simple message to encrypt";

    // will hold out encrypted message
    std::vector<uint8_t> encryptedBytes;

    // encrypt the data.
    for (auto it = str.begin(); it != str.end();)
    {
        uint8_t plain[16] = {0}, enc[16] = {0};
        size_t i = 0;
        for (; it != str.end() && i < 16; ++i,++it)
            plain[i] = *it;
        aes_encrypt(&ctx, plain, enc);
        encryptedBytes.insert(encryptedBytes.end(), enc, enc+16);
    }

    // now decrypt (not sure if this api requires resetting the
    //  key schedule, but it seems it can't hurt).
    aes_set_key(&ctx, key, 128);
    std::vector<uint8_t> decrypted;
    for (auto it = encryptedBytes.begin(); it != encryptedBytes.end(); it = std::next(it,16))
    {
        uint8_t tmp[16];
        aes_decrypt(&ctx, &(*it), tmp);
        decrypted.insert(decrypted.end(), tmp, tmp+16);
    }

    // rebuild string from data. stop at the terminator or end.
    auto last = std::find(decrypted.begin(), decrypted.end(), 0);
    std::string res(decrypted.begin(), last);

    // show all three (original, cipher, decrypted)
    std::cout << str << '\n';
    print_hex(encryptedBytes.begin(), encryptedBytes.end());
    std::cout << res << '\n';

    return 0;
}