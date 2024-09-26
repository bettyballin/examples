cpp
#include <iostream>

int main() {
    long long a, b;
    a = 2000000000;
    b = 2000000000;

    if((a >= 2000000000 || a <= -2000000000) ||
       (b >= 2000000000 || b <= -2000000000) || 
       ((a+b) >= 2000000000 || (a+b) <= -2000000000)){
        std::cout << "Condition met" << std::endl;
    } else {
        std::cout << "Condition not met" << std::endl;
    }

    return 0;
}