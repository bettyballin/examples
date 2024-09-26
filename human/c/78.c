#include <stdio.h>
#include <stdlib.h>

int main() {
    int N;
    printf("Enter the number of bits: ");
    scanf("%d", &N);

    int A[N], B[N];
    printf("Enter bits for A: ");
    for (int i = 0; i < N; i++) {
        scanf("%d", &A[i]);
    }

    printf("Enter bits for B: ");
    for (int i = 0; i < N; i++) {
        scanf("%d", &B[i]);
    }

    int result = 1;
    for (int i = 0; i < N; i++) {
        result *= (A[i] ^ B[i]);
    }

    printf("Result of A ^ B = %d\n", result);

    return 0;
}