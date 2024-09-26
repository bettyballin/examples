#include <stdio.h>

int main() {
    int z = 26;
    int rs2[26] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
    int temp;

    if (z == 26) {
        z = 0;
        temp = rs2[0];
        for (int s = 0; s < 26 - 1; s++) {
            rs2[s] = rs2[s + 1];
        }
        rs2[26 - 1] = temp;
    }

    for (int i = 0; i < 26; i++) {
        printf("%d ", rs2[i]);
    }
    return 0;
}