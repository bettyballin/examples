cpp
#include <iostream>
#include <string>

void Test(std::string x, int key) {
    // Your implementation here
    std::cout << "Testing with key: " << key << std::endl;
}

void bruteForce(std::string x) {
    int key = 0;
    for (int i = 0; i < 25; i++) {
        key++;
        Test(x, key);
    }
}

int main() {
    std::string x = "your_string_here";
    bruteForce(x);
    return 0;
}