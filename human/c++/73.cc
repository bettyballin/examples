cpp
#include <iostream>

int encrypt(int num) {
    return ~num + 1;
}

int decrypt(int num) {
    return ~num + 1;
}

int main() {
    int num = 1234;
    std::cout << "Before encryption: " << num << std::endl;
    int encrypted_num = encrypt(num);
    std::cout << "After encryption: " << encrypted_num << std::endl;
    int decrypted_num = decrypt(encrypted_num);
    std::cout << "After decryption: " << decrypted_num << std::endl;
    return 0;
}