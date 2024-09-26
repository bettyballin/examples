cpp
#include <iostream>
#include <string>

void xor_crypt(const char *key, int key_len, char *data, int data_len)
{
    for (int i = 0; i < data_len; i++)
        data[i] ^= key[ i % key_len ];
}

int main()
{
    const char key[] = "secret";
    int key_len = sizeof(key) - 1;
    char data[] = "Hello, World!";
    int data_len = sizeof(data) - 1;

    std::cout << "Original data: " << data << std::endl;
    xor_crypt(key, key_len, data, data_len);
    std::cout << "Encrypted data: " << data << std::endl;
    xor_crypt(key, key_len, data, data_len);
    std::cout << "Decrypted data: " << data << std::endl;

    return 0;
}