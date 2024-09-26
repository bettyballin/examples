#include <stdio.h>

int main() {
    int i = 5; // assuming some value for i
    int f[1024] = {0}; // initializing array f with zeros
    int t = *(&i); // fixing the syntax error

    for (int j = 0; j < 1024; ++j)
        f[j] += t;

    return 0;
}