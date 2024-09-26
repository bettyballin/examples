cpp
#include <iostream>
#include <string>

int main() {
    std::string ctext = "";
    std::string message = "attackatdawn";
    int a = 3;
    int b = 7;

    for (int i = 0; i < message.length(); i++) {
        ctext = ctext + (char)((((a * (message[i] - 'a')) + b) % 26) + 65);
    }

    std::cout << ctext << std::endl;

    return 0;
}