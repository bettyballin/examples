cpp
#include <iostream>

static int seed = 0;

void srand(int newSeed)
{
    seed = newSeed;
}

int rand()
{
    seed = (int) ((1103515245 * ((unsigned int)seed) + 12345) & 0x7fffffffUL); 
    return seed;
}

int main() {
    srand(123);
    std::cout << rand() << std::endl;
    return 0;
}