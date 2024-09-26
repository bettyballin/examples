#include <stdio.h>

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
    srand(10);
    for (int i = 0; i < 10; i++) {
        printf("%d\n", rand());
    }
    return 0;
}