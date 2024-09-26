cpp
#include <iostream>

class Blockchain {
public:
    friend std::ostream & operator<<(std::ostream & out, const Blockchain & p);
};

std::ostream & operator<<(std::ostream & out, const Blockchain & p) {
    out << "Blockchain object" << std::endl;
    return out;
}

int main() {
    Blockchain bc;
    std::cout << bc;
    return 0;
}