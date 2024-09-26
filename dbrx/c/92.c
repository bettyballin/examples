#include <stdio.h>

int main() {
    char ans[5];

    if (scanf("%4s", ans) != 1) {
        // Handle error: invalid input format or end-of-file reached.
        printf("Error reading input.\n");
        return 1;
    }

    printf("You entered: %s\n", ans);

    return 0;
}