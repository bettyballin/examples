#include <stdio.h>
#include <stdlib.h>

int main() {
    char ans[100];

    if(scanf("%99s", ans) != 1){
        fprintf(stderr, "Error reading input\n");
        return EXIT_FAILURE;
    }

    // Rest of your code
    printf("You entered: %s\n", ans);

    return EXIT_SUCCESS;
}