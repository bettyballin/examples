cpp
#include <iostream>
#include <string>
#include <algorithm>

int main() {
    std::string pwd;
    std::cout << "Enter password: ";
    std::getline(std::cin, pwd);

    std::fill_n(&pwd[0], pwd.capacity()-1, 0xff);  // really overwrite

    return 0;
}