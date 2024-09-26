cpp
#include <iostream>
#include <string>
#include <vector>

void xor_crypt(const std::string &key, std::vector<char>& data)
{
    for (size_t i = 0; i != data.size(); i++)
        data[i] ^= key[ i % key.size() ];
}

int main()
{
    std::string key = "secret";
    std::string message = "Hello, World!";
    std::vector<char> data(message.begin(), message.end());

    std::cout << "Original message: ";
    for (char c : data)
        std::cout << c;
    std::cout << std::endl;

    xor_crypt(key, data);

    std::cout << "Encrypted message: ";
    for (char c : data)
        std::cout << c;
    std::cout << std::endl;

    xor_crypt(key, data);

    std::cout << "Decrypted message: ";
    for (char c : data)
        std::cout << c;
    std::cout << std::endl;

    return 0;
}