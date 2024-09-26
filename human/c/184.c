#include <stdlib.h>

int main(void)
{
    int* pi1  = malloc(10*sizeof(int));
    if (pi1 != NULL && pi1[5]) 
        ;
    free(pi1);

    int* pi2 = malloc(10*sizeof(int));
    int value = pi2[5];
    free(pi2);
    if (value) 
        ;

    int* pi3 = NULL; // You can't assign a random address in C
    if (pi3 != NULL && *pi3) 
       ;
}