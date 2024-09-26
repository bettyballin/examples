cpp
#include <iostream>

inline int positive_modulo(int i, int n) {
    return (i % n + n) % n;
}

int main() {
    int i = -5;
    int n = 10;
    std::cout << "Positive modulo of " << i << " with " << n << " is: " << positive_modulo(i, n) << std::endl;
    return 0;
}