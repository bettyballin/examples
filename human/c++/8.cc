cpp
#include <iostream>
#include <cstdlib>
#include <ctime>

int main() {
    srand(time(0)); // seed for random number generation

    std::string plaintext;
    std::cout << "Enter the plaintext: ";
    std::cin >> plaintext;

    std::string keystream = "";
    for (int i = 0; i < plaintext.length() * 4; i++) {
        keystream += (rand() % 2 == 0) ? '0' : '1'; // generate random keystream
    }

    std::string ciphertext = "";
    int keystreamIndex = 0;
    for (char c : plaintext) {
        if (!isdigit(c)) {
            std::cerr << "Invalid input. Only decimal digits allowed." << std::endl;
            return 1;
        }

        int digit = c - '0';
        int number;
        do {
            std::string bits = keystream.substr(keystreamIndex, 4);
            keystreamIndex += 4;
            number = stoi(bits, 0, 2);
        } while (number >= 10);

        int encryptedDigit = (digit + number) % 10;
        ciphertext += encryptedDigit + '0';
    }

    std::cout << "Ciphertext: " << ciphertext << std::endl;

    return 0;
}