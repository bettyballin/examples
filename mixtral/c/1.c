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

int main() {
    int num1, num2;
    printf("Enter two numbers: ");
    scanf("%d %d", &num1, &num2);
    printf("GCD of %d and %d is %d\n", num1, num2, gcd(num1, num2));
    return 0;
}