cpp
#include <iostream>
#include <string>

template <typename Integer>
class IntToString {
public:
    std::string operator()(Integer value, int base = 10) {
        static const char* digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        std::string result;

        if (value < 0) {
            result += '-';
            value = -value;
        }

        do {
            result = digits[value % base] + result;
            value /= base;
        } while (value);

        return result;
    }
};

int main() {
    IntToString<int> converter;
    int value = 255;

    std::cout << converter(value, 16) << std::endl;  // Output: FF
    std::cout << converter(value, 10) << std::endl;  // Output: 255
    std::cout << converter(value, 8) << std::endl;   // Output: 377

    return 0;
}