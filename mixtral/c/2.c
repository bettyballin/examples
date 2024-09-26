#include <stdio.h>

int gcd(int r1, int r2) {
    if (r2 == 0)
        return r1;

    while (r2 > 0) {
       // Update the values of r1 and r2
       int temp = r1 % r2;
       r1 = r2;
       r2 = temp;
   }

   return r1;
}

int main()
{
    char input[30];
    int a, b;

    printf("Enter value of a: ");

    // Use fgets instead of scanf for better security
    if (fgets(input, sizeof(input), stdin) != NULL && sscanf(input, "%d", &a) == 1) {
        printf("Enter value of b: ");

        if (fgets(input, sizeof(input), stdin) != NULL && sscanf(input, "%d", &b) == 1) {
            printf("GCD of %d and %d is: %d\n", a, b, gcd(a, b));
        } else {
            printf("Invalid input for b\n");
        }
    } else {
        printf("Invalid input for a\n");
    }

    return 0;
}