#include <stdio.h>

int main(int argc, char **argv){
    int i;

    for(i = 0 ; argv[1][i] != '\0' && i<4 ; ++i)
        printf("%x ", (unsigned char)(argv[1][i]));

    return 0;
}