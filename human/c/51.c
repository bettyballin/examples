#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int rand_in_range_min_to_max(int min, int max) {
    return min + (int)((max - min) * ((double)rand() / RAND_MAX));
}

int main() {
    srand(time(NULL));
    int min = 1;
    int max = 100;
    printf("%d\n", rand_in_range_min_to_max(min, max));
    return 0;
}