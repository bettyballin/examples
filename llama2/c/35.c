#include <stdio.h>

char reflector[] = "YRUHQSLDPXNGOKMIEBFZCWVJAT";

char reflect(char c){
    int num=(int)c-65;
    return reflector[num%26];
}

int main() {
    char c = 'A';
    printf("%c\n", reflect(c));
    return 0;
}