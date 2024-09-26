#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <time.h>

#define MT_GETRANDMAX 2147483647

int main() {
    srand(time(NULL));
    int rand_in_range_min_to_max = 10;
    int min = 1;
    int max = 100;

    int rand_min = (int)(((rand_in_range_min_to_max - min) / (float)(max - min)) * MT_GETRANDMAX);
    int rand_max = (int)(rand_min + MT_GETRANDMAX / (float)(max - min + 1));

    for (int rand = rand_min; rand <= rand_max; rand++) {
        assert(rand_in_range_min_to_max == (int)(min + (float)(max - min) * ((float)rand/MT_GETRANDMAX)));
    }

    printf("Assertions passed\n");
    return 0;
}