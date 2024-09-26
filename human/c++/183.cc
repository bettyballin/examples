cpp
#include <iostream>
#include <cstdlib>
#include <ctime>

int main() {
    srand(time(0)); // seed the random number generator
    int number = rand() * 2000 / (RAND_MAX+1);
    std::cout << number << std::endl;
    return 0;
}