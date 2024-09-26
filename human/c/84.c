#include <stdio.h>
#include <string.h>

#define MAX 100

void encrypt(int rail, char *plain) {
    char railfence[rail][MAX], buf[2];
    int i, col = 0, j, len; 
    int number = 0, increment = 1;

    buf[1] = '\0';
    for (i = 0; i < rail; i++)
        railfence[i][0] = '\0';

    for (i = 0; i < strlen(plain); i++) {
        if (number + increment == rail)
            increment = -1;
        else if (number + increment == -1)
            increment = 1;

        buf[0] = plain[i];
        strcat(railfence[number], buf);
        number += increment;
    }
    for (i = 0; i < rail; i++) {
        len = strlen(railfence[i]); 
        for (j = 0; j < len; ++j) 
        {
            printf("%c", railfence[i][j]);
            if (++col == 79) {
                col = 0;
                printf("\n");
            }
        }
    }
}

int main() {
    char plain[] = "Hello, World!";
    int rail = 3;
    encrypt(rail, plain);
    return 0;
}