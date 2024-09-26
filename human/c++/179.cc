cpp
#include <random>
#include <iostream>

int main() {
    std::random_device my_random_device;
    std::default_random_engine my_random_engine(my_random_device());
    return 0;
}