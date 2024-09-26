cpp
#include <iostream>
#include <string>
#include <random>

int main() {
    std::string salt;
    salt.reserve(32);

    std::random_device rd;
    std::mt19937 my_random_engine(rd());
    std::uniform_int_distribution<int> random_number(0, 61);

    std::string charset = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    for (int i = 0; i < 32; i++) {
        salt.push_back(charset[random_number(my_random_engine)]);
    }

    std::cout << "salt result: " << salt << std::endl;

    return 0;
}