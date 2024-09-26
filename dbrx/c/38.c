#include <stdio.h>
#include <stdbool.h>

bool isValidAddition(unsigned int x, unsigned int y) {
    if(x + y < x)
        return false;
    else 
        return true;
}

int main() {
    unsigned int x = 2000000000;
    unsigned int y = 2000000000;
    printf("%d\n", isValidAddition(x, y));
    return 0;
}