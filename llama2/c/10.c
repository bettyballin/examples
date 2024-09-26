#include <stdio.h>

void greet(char *username) { 
    printf("Hello %s!\n", username); 
}

int main() {
    greet("World");
    return 0;
}