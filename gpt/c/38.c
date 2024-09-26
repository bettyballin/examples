
#include <stdio.h>

int gcd(int r1, int r2) {
    int r;
    while(r2 != 0) {
        r = r1 % r2;
        r1 = r2;
        r2 = r;
    }
    return r1;
}

int main() {
    int a, b, ans;
    printf("Enter value of a: ");
    scanf("%d", &a);
    printf("Enter value of b: ");
    scanf("%d", &b);
    ans = gcd(a, b);
    printf("The GCD of %d and %d is %d\n", a, b, ans);
    return 0;
}

