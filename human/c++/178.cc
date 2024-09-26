cpp
#include <iostream>
#include <string>
#include <ctime>
#include <cstdlib>

const char charset[] =
    "0123456789"
    "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    "abcdefghijklmnopqrstuvwxyz"
    "!\xA3$%^&*():@~#'?/<>,.|`\xAC\xA6";

int main() {
    srand(time(0));
    int length = 10; // change this to get different length strings
    std::string str(length, 0);
    for(int i = 0; i < length; ++i) {
        str[i] = charset[rand() % (sizeof(charset) - 1)];
    }
    std::cout << str << std::endl;
    return 0;
}