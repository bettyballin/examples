cpp
#include <iostream>
#include <random>
#include <string>

int main() {
    const std::string charset = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    std::random_device rd;
    std::mt19937 gen(rd());
    std::uniform_int_distribution<int> random_number(0, charset.size() - 1);
    std::cout << charset[random_number(gen)] << std::endl;
    return 0;
}