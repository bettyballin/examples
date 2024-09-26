#include <ctype.h>

int main() {
    char ans[2], ans1[2];

    printf("Enter your answer (y/n): ");
    scanf("%s", ans);

    if ((char)tolower(ans[0]) == 'y') {
        // Rest of your code
    }

    printf("Enter your second answer (y/n): ");
    scanf("%s", ans1);

    if ((char)tolower(ans1[0]) == 'y') {
        // Rest of your code
    }

    return 0;
}