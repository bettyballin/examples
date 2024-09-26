cpp
#include <iostream>
#include <cstdlib>

int main() {
    char *a = (char*)malloc(100);
    char *b = (char*)malloc(100);
    char *c = (char*)malloc(100);
    for (int i = 0; i < 100; i++) {
        b[i] = 'Z';
    }
    free(a);
    free(b);
    free(c);
    return 0;
}