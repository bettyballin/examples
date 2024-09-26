cpp
#include <iostream>
#include <cstdlib>
#include <ctime>

int main() {
    // Seed randomizer
    srand( time(0) );

    // Print a random number between 0 and 1999
    int number = rand() % 2000;
    std::cout << number;

    return 0;
}