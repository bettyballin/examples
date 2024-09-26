
#include <stdio.h>

void vulnerable_function(char *user_input) {
    printf(user_input); // This is vulnerable because the user input is treated as a format string
}

int main(int argc, char *argv[]) {
    vulnerable_function(argv[1]);
    return 0;
}

